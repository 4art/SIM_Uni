package com.sim.module.transaction.service;

import com.sim.module.transaction.model.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface TransactionService {
  Optional<List<Transaction>> findByCompanyId(int companyId);

  CompletableFuture<Optional<List<Transaction>>> findByCompanyIdAsync(int companyId);

}
