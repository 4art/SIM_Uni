package com.sim.module.insider.model;

public class InsiderRelation {
  private boolean other;
  private boolean officer;
  private boolean director;
  private boolean tenPercentOwner;
  private String officerTitle;

  public boolean isOther() {
    return other;
  }

  public void setOther(boolean other) {
    this.other = other;
  }

  public boolean isOfficer() {
    return officer;
  }

  public void setOfficer(boolean officer) {
    this.officer = officer;
  }

  public boolean isDirector() {
    return director;
  }

  public void setDirector(boolean director) {
    this.director = director;
  }

  public boolean isTenPercentOwner() {
    return tenPercentOwner;
  }

  public void setTenPercentOwner(boolean tenPercentOwner) {
    this.tenPercentOwner = tenPercentOwner;
  }

  public String getOfficerTitle() {
    return officerTitle;
  }

  public void setOfficerTitle(String officerTitle) {
    this.officerTitle = officerTitle;
  }

  @Override
  public String toString() {
    return "InsiderRelation{" +
        "other=" + other +
        ", officer=" + officer +
        ", director=" + director +
        ", tenPercentOwner=" + tenPercentOwner +
        ", officerTitle='" + officerTitle + '\'' +
        '}';
  }
}
