package com.sim.module.transaction.model;

import java.util.Date;

public class TransactionInfo {
  private String security;
  private Number shares;
  private Double price;
  private String currency;
  private Double valueUSD;
  private Double holding;
  private TransactionType transactionType;
  private Date date;

  public String getSecurity() {
    return security;
  }

  public void setSecurity(String security) {
    this.security = security;
  }

  public Number getShares() {
    return shares;
  }

  public void setShares(Number shares) {
    this.shares = shares;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Double getValueUSD() {
    return valueUSD;
  }

  public void setValueUSD(Double valueUSD) {
    this.valueUSD = valueUSD;
  }

  public Double getHolding() {
    return holding;
  }

  public void setHolding(Double holding) {
    this.holding = holding;
  }

  public TransactionType getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "TransactionInfo{" +
        "security='" + security + '\'' +
        ", shares=" + shares +
        ", price=" + price +
        ", currency='" + currency + '\'' +
        ", valueUSD=" + valueUSD +
        ", holding=" + holding +
        ", transactionType=" + transactionType +
        ", date=" + date +
        '}';
  }
}
