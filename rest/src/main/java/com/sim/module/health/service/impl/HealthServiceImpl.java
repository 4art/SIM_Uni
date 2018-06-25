package com.sim.module.health.service.impl;

import com.sim.module.health.model.Health;
import com.sim.module.health.model.HealthBuilder;
import com.sim.module.health.service.HealthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HealthServiceImpl implements HealthService {

  @Override
  public Health checkFullHealth() {
    return HealthBuilder.aHealth()
        .withSuccess(true)
        .build();
  }
}
