package com.sim.module.transaction.model.builder;


import com.sim.module.insider.model.Insider;
import com.sim.module.transaction.model.Transaction;
import com.sim.module.transaction.model.TransactionInfo;

public final class TransactionBuilder {
  private Insider insider;
  private TransactionInfo transactionInfo;

  private TransactionBuilder() {
  }

  public static TransactionBuilder aTransaction() {
    return new TransactionBuilder();
  }

  public TransactionBuilder withInsider(Insider insider) {
    this.insider = insider;
    return this;
  }

  public TransactionBuilder withTransactionInfo(TransactionInfo transactionInfo) {
    this.transactionInfo = transactionInfo;
    return this;
  }

  public Transaction build() {
    Transaction transaction = new Transaction();
    transaction.setInsider(insider);
    transaction.setTransactionInfo(transactionInfo);
    return transaction;
  }
}
