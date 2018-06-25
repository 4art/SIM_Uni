package com.sim.module.health.model;

import java.util.List;

public final class HealthBuilder {
  private boolean success;
  private List<String> errors;

  private HealthBuilder() {
  }

  public static HealthBuilder aHealth() {
    return new HealthBuilder();
  }

  public HealthBuilder withSuccess(boolean success) {
    this.success = success;
    return this;
  }

  public HealthBuilder withErrors(List<String> errors) {
    this.errors = errors;
    return this;
  }

  public Health build() {
    Health health = new Health();
    health.setSuccess(success);
    health.setErrors(errors);
    return health;
  }
}
