package com.sim.module.transaction.service;

import com.sim.IntegrationTest;
import com.sim.module.transaction.model.Transaction;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class TransactionServiceTest extends IntegrationTest {

  @Autowired
  private TransactionService transactionService;

  @Test
  public void findByCompanyId() {
    final Optional<List<Transaction>> byCompanyId = transactionService.findByCompanyId(colaCom.getId());
    assertTrue(byCompanyId.isPresent());
    byCompanyId.ifPresent(transactions -> {
      assertFalse(transactions.isEmpty());
      transactions.forEach(transaction -> {
        assertNotNull(transaction.getTransactionInfo().getTransactionType());
        assertNotEquals(transaction.getInsider().getRelation().getOfficerTitle(), "");
      });
    });
  }
}
