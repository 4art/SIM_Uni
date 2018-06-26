package com.sim.module.insider.model.builder;

import com.sim.module.company.model.Company;
import com.sim.module.insider.model.Insider;
import com.sim.module.insider.model.InsiderAddress;
import com.sim.module.insider.model.InsiderRelation;

import java.util.List;

public final class InsiderBuilder {
  private int id;
  private String name;
  private List<InsiderAddress> addresses;
  private Company company;
  private InsiderRelation relation;

  private InsiderBuilder() {
  }

  public static InsiderBuilder anInsider() {
    return new InsiderBuilder();
  }

  public InsiderBuilder withId(int id) {
    this.id = id;
    return this;
  }

  public InsiderBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public InsiderBuilder withAddresses(List<InsiderAddress> addresses) {
    this.addresses = addresses;
    return this;
  }

  public InsiderBuilder withCompany(Company company) {
    this.company = company;
    return this;
  }

  public InsiderBuilder withRelation(InsiderRelation relation) {
    this.relation = relation;
    return this;
  }

  public Insider build() {
    Insider insider = new Insider();
    insider.setId(id);
    insider.setName(name);
    insider.setAddresses(addresses);
    insider.setCompany(company);
    insider.setRelation(relation);
    return insider;
  }
}
