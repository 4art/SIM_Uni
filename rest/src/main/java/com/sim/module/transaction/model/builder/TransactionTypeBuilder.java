package com.sim.module.transaction.model.builder;

import com.sim.module.transaction.model.TransactionCode;
import com.sim.module.transaction.model.TransactionType;

public final class TransactionTypeBuilder {
  private TransactionCode code;
  private String label;
  private String description;

  private TransactionTypeBuilder() {
  }

  public static TransactionTypeBuilder aTransactionType() {
    return new TransactionTypeBuilder();
  }

  public TransactionTypeBuilder withCode(TransactionCode code) {
    this.code = code;
    return this;
  }

  public TransactionTypeBuilder withLabel(String label) {
    this.label = label;
    return this;
  }

  public TransactionTypeBuilder withDescription(String description) {
    this.description = description;
    return this;
  }

  public TransactionType build() {
    TransactionType transactionType = new TransactionType();
    transactionType.setCode(code);
    transactionType.setLabel(label);
    transactionType.setDescription(description);
    return transactionType;
  }
}
