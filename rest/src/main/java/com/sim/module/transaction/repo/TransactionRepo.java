package com.sim.module.transaction.repo;

import com.sim.module.transaction.model.Transaction;
import com.sim.module.transaction.model.TransactionType;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface TransactionRepo {
  Optional<List<Transaction>> findByCompanyId(int companyId);

  CompletableFuture<Optional<List<Transaction>>> findByCompanyIdAsync(int companyId);

  Optional<List<TransactionType>> findAllTransactionTypes();

  CompletableFuture<Optional<List<TransactionType>>> findAllTransactionTypesAsync();
}
