package com.sim.module.insider.model;


import com.sim.module.company.model.Company;

public class Insider {
  private int id;
  private String name;
  private InsiderAddress address;
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

  public InsiderAddress getAddress() {
    return address;
  }

  public void setAddress(InsiderAddress address) {
    this.address = address;
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
        ", address=" + address +
        ", company=" + company +
        ", relation=" + relation +
        '}';
  }
}
