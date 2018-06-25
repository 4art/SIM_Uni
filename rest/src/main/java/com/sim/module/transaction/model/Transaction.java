package com.sim.module.transaction.model;


import com.sim.module.insider.model.Insider;

public class Transaction {
  private Insider insider;
  private TransactionInfo transactionInfo;

  public Insider getInsider() {
    return insider;
  }

  public void setInsider(Insider insider) {
    this.insider = insider;
  }

  public TransactionInfo getTransactionInfo() {
    return transactionInfo;
  }

  public void setTransactionInfo(TransactionInfo transactionInfo) {
    this.transactionInfo = transactionInfo;
  }

  @Override
  public String toString() {
    return "Transaction{" +
        "insider=" + insider +
        ", transactionInfo=" + transactionInfo +
        '}';
  }
}
