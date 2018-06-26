package com.sim.module.insider.model.builder;

import com.sim.module.insider.model.InsiderRelation;

public final class InsiderRelationBuilder {
  private boolean other;
  private boolean officer;
  private boolean director;
  private boolean tenPercentOwner;
  private String officerTitle;

  private InsiderRelationBuilder() {
  }

  public static InsiderRelationBuilder anInsiderRelation() {
    return new InsiderRelationBuilder();
  }

  public InsiderRelationBuilder withOther(boolean other) {
    this.other = other;
    return this;
  }

  public InsiderRelationBuilder withOfficer(boolean officer) {
    this.officer = officer;
    return this;
  }

  public InsiderRelationBuilder withDirector(boolean director) {
    this.director = director;
    return this;
  }

  public InsiderRelationBuilder withTenPercentOwner(boolean tenPercentOwner) {
    this.tenPercentOwner = tenPercentOwner;
    return this;
  }

  public InsiderRelationBuilder withOfficerTitle(String officerTitle) {
    this.officerTitle = officerTitle;
    return this;
  }

  public InsiderRelation build() {
    InsiderRelation insiderRelation = new InsiderRelation();
    insiderRelation.setOther(other);
    insiderRelation.setOfficer(officer);
    insiderRelation.setDirector(director);
    insiderRelation.setTenPercentOwner(tenPercentOwner);
    insiderRelation.setOfficerTitle(officerTitle);
    return insiderRelation;
  }
}
