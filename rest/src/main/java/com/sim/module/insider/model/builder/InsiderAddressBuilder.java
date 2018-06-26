package com.sim.module.insider.model.builder;

import com.sim.module.insider.model.InsiderAddress;

public final class InsiderAddressBuilder {
  private String country;
  private String city;
  private String state;
  private String name;
  private String street;
  private String zip;
  private String description;

  private InsiderAddressBuilder() {
  }

  public static InsiderAddressBuilder anInsiderAddress() {
    return new InsiderAddressBuilder();
  }

  public InsiderAddressBuilder withCountry(String country) {
    this.country = country;
    return this;
  }

  public InsiderAddressBuilder withCity(String city) {
    this.city = city;
    return this;
  }

  public InsiderAddressBuilder withState(String state) {
    this.state = state;
    return this;
  }

  public InsiderAddressBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public InsiderAddressBuilder withStreet(String street) {
    this.street = street;
    return this;
  }

  public InsiderAddressBuilder withZip(String zip) {
    this.zip = zip;
    return this;
  }

  public InsiderAddressBuilder withDescription(String description) {
    this.description = description;
    return this;
  }

  public InsiderAddress build() {
    InsiderAddress insiderAddress = new InsiderAddress();
    insiderAddress.setCountry(country);
    insiderAddress.setCity(city);
    insiderAddress.setState(state);
    insiderAddress.setName(name);
    insiderAddress.setStreet(street);
    insiderAddress.setZip(zip);
    insiderAddress.setDescription(description);
    return insiderAddress;
  }
}
