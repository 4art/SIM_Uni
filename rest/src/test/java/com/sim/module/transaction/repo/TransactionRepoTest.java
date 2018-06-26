package com.sim.module.transaction.repo;

import com.sim.IntegrationTest;
import com.sim.module.transaction.model.Transaction;
import com.sim.module.transaction.model.TransactionType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class TransactionRepoTest extends IntegrationTest {

  @Autowired
  private TransactionRepo transactionRepo;

  @Test
  public void findByCompanyId() {
    final Optional<List<Transaction>> byCompanyId = transactionRepo.findByCompanyId(colaCom.getId());
    assertTrue(byCompanyId.isPresent());
    byCompanyId.ifPresent(transactions -> assertFalse(transactions.isEmpty()));
  }

  @Test
  public void findAllTransactionTypes() {
    final Optional<List<TransactionType>> allTransactionTypes = transactionRepo.findAllTransactionTypes();
    assertTrue(allTransactionTypes.isPresent());
    allTransactionTypes.ifPresent(transactions -> assertFalse(transactions.isEmpty()));
  }
}
