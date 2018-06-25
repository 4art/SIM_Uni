package com.sim.module.insider.model;

public class InsiderAddress {
  private String country;
  private String city;
  private String state;
  private String name;
  private String street;
  private String zip;
  private String description;

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "InsiderAddress{" +
        "country='" + country + '\'' +
        ", city='" + city + '\'' +
        ", state='" + state + '\'' +
        ", name='" + name + '\'' +
        ", street='" + street + '\'' +
        ", zip='" + zip + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
