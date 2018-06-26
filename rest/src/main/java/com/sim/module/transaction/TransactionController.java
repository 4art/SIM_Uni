package com.sim.module.transaction;

import com.sim.module.transaction.model.Transaction;
import com.sim.module.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionController {

  @Autowired
  private TransactionService transactionService;

  @GetMapping("/transactions/{companyId}")
  public List<Transaction> findTransactionsByCompanyId(@PathVariable Integer companyId) {
    return transactionService.findByCompanyId(companyId).orElse(new ArrayList<>());
  }
}
