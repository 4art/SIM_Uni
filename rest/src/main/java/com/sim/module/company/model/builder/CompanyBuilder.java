package com.sim.module.company.model.builder;

import com.sim.module.company.model.Company;

public final class CompanyBuilder {
  private Integer id;
  private String name;
  private String symbol;

  private CompanyBuilder() {
  }

  public static CompanyBuilder aCompany() {
    return new CompanyBuilder();
  }

  public CompanyBuilder withId(Integer id) {
    this.id = id;
    return this;
  }

  public CompanyBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public CompanyBuilder withSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public Company build() {
    Company company = new Company();
    company.setId(id);
    company.setName(name);
    company.setSymbol(symbol);
    return company;
  }
}
