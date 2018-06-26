package com.sim.module.insider.model;

import com.sim.module.company.model.Company;

import java.util.List;

public class Insider {
  private int id;
  private String name;
  private List<InsiderAddress> addresses;
  private Company company;
  private InsiderRelation relation;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<InsiderAddress> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<InsiderAddress> addresses) {
    this.addresses = addresses;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public InsiderRelation getRelation() {
    return relation;
  }

  public void setRelation(InsiderRelation relation) {
    this.relation = relation;
  }

  @Override
  public String toString() {
    return "Insider{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", addresses=" + addresses +
        ", company=" + company +
        ", relation=" + relation +
        '}';
  }
}
