package com.sim.module.transaction.model.builder;

import eu.metraf.rest.module.transaction.model.Transaction;
import eu.metraf.rest.module.transaction.model.TransactionStaticDto;

import java.util.Date;
import java.util.List;

public final class TransactionStaticDtoBuilder {
  private Integer id;
  private Integer companyId;
  private List<Transaction> transactions;
  private Date date;

  private TransactionStaticDtoBuilder() {
  }

  public static TransactionStaticDtoBuilder aTransactionStaticDto() {
    return new TransactionStaticDtoBuilder();
  }

  public TransactionStaticDtoBuilder withId(Integer id) {
    this.id = id;
    return this;
  }

  public TransactionStaticDtoBuilder withCompanyId(Integer companyId) {
    this.companyId = companyId;
    return this;
  }

  public TransactionStaticDtoBuilder withTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
    return this;
  }

  public TransactionStaticDtoBuilder withDate(Date date) {
    this.date = date;
    return this;
  }

  public TransactionStaticDto build() {
    TransactionStaticDto transactionStaticDto = new TransactionStaticDto();
    transactionStaticDto.setId(id);
    transactionStaticDto.setCompanyId(companyId);
    transactionStaticDto.setTransactions(transactions);
    transactionStaticDto.setDate(date);
    return transactionStaticDto;
  }
}
