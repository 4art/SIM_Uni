package com.sim.module.transaction.service;

import com.sim.module.transaction.model.Transaction;
import com.sim.module.transaction.model.TransactionCode;
import com.sim.module.transaction.model.TransactionType;
import com.sim.module.transaction.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

  private final TransactionRepo transactionRepo;
  private CompletableFuture<Optional<List<TransactionType>>> allTransactionTypes;

  @Autowired
  public TransactionServiceImpl(TransactionRepo transactionRepo) {
    this.transactionRepo = transactionRepo;
    ;
  }

  @Override
  public Optional<List<Transaction>> findByCompanyId(int companyId) {
    allTransactionTypes = this.transactionRepo.findAllTransactionTypesAsync();
    return transactionRepo.findByCompanyId(companyId).map(transactions1 -> transactions1.stream().map(this::transactionFilter).collect(Collectors.toList()));
  }

  @Async
  @Override
  public CompletableFuture<Optional<List<Transaction>>> findByCompanyIdAsync(int companyId) {
    return CompletableFuture.completedFuture(findByCompanyId(companyId));
  }

  private Transaction transactionFilter(Transaction transaction) {
    if (transaction.getInsider().getRelation().getOfficerTitle().equals("")) {
      String officerTitle = "";
      if (transaction.getInsider().getRelation().isDirector()) {
        officerTitle += "Director";
      }
      if (transaction.getInsider().getRelation().isOfficer()) {
        officerTitle += " Officer";
      }

      if (transaction.getInsider().getRelation().isTenPercentOwner()) {
        officerTitle += " TenPercentOwner";
      }
      if (transaction.getInsider().getRelation().isOther()) {
        officerTitle += " Other";
      }
      transaction.getInsider().getRelation().setOfficerTitle(officerTitle);
    }
    if(transaction.getTransactionInfo().getTransactionType() == null){
      allTransactionTypes.join().ifPresent(transactionTypes -> transaction.getTransactionInfo().setTransactionType(transactionTypes.stream().filter(transactionType -> transactionType.getCode() == TransactionCode.J).collect(Collectors.toList()).get(0)));
    }
    return transaction;
  }
}
