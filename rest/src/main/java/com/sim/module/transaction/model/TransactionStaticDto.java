package com.sim.module.transaction.model;

import java.util.Date;
import java.util.List;

public class TransactionStaticDto {
  private Integer id;
  private Integer companyId;
  private List<Transaction> transactions;
  private Date date;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Integer companyId) {
    this.companyId = companyId;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "TransactionStaticDto{" +
        "id=" + id +
        ", companyId=" + companyId +
        ", transactions=" + transactions +
        ", date=" + date +
        '}';
  }
}
