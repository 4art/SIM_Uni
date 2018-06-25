package com.sim.module.insider.model.builder;

import eu.metraf.rest.module.companies.model.Company;
import eu.metraf.rest.module.insider.model.Insider;
import eu.metraf.rest.module.insider.model.InsiderAddress;
import eu.metraf.rest.module.insider.model.InsiderRelation;

public final class InsiderBuilder {
  private int id;
  private String name;
  private InsiderAddress address;
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

  public InsiderBuilder withAddress(InsiderAddress address) {
    this.address = address;
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
    insider.setAddress(address);
    insider.setCompany(company);
    insider.setRelation(relation);
    return insider;
  }
}
