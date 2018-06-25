package com.sim.module.health;

import com.sim.module.health.model.Health;
import com.sim.module.health.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

  @Autowired
  private HealthService healthService;

  @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public Health checkHealth() {
    return healthService.checkFullHealth();
  }
}
