package com.sim.module.transaction.model.builder;

import eu.metraf.rest.module.transaction.model.TransactionInfo;
import eu.metraf.rest.module.transaction.model.TransactionType;

import java.util.Date;

public final class TransactionInfoBuilder {
  private String security;
  private Number shares;
  private Double price;
  private String currency;
  private Double valueUSD;
  private Double holding;
  private TransactionType transactionType;
  private Date date;

  private TransactionInfoBuilder() {
  }

  public static TransactionInfoBuilder aTransactionInfo() {
    return new TransactionInfoBuilder();
  }

  public TransactionInfoBuilder withSecurity(String security) {
    this.security = security;
    return this;
  }

  public TransactionInfoBuilder withShares(Number shares) {
    this.shares = shares;
    return this;
  }

  public TransactionInfoBuilder withPrice(Double price) {
    this.price = price;
    return this;
  }

  public TransactionInfoBuilder withCurrency(String currency) {
    this.currency = currency;
    return this;
  }

  public TransactionInfoBuilder withValueUSD(Double valueUSD) {
    this.valueUSD = valueUSD;
    return this;
  }

  public TransactionInfoBuilder withHolding(Double holding) {
    this.holding = holding;
    return this;
  }

  public TransactionInfoBuilder withTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
    return this;
  }

  public TransactionInfoBuilder withDate(Date date) {
    this.date = date;
    return this;
  }

  public TransactionInfo build() {
    TransactionInfo transactionInfo = new TransactionInfo();
    transactionInfo.setSecurity(security);
    transactionInfo.setShares(shares);
    transactionInfo.setPrice(price);
    transactionInfo.setCurrency(currency);
    transactionInfo.setValueUSD(valueUSD);
    transactionInfo.setHolding(holding);
    transactionInfo.setTransactionType(transactionType);
    transactionInfo.setDate(date);
    return transactionInfo;
  }
}
