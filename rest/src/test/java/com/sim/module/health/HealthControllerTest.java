package com.sim.module.health;

import com.sim.IntegrationTest;
import com.sim.module.health.model.Health;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

public class HealthControllerTest extends IntegrationTest {

  @Test
  public void checkHealth() {
    final ResponseEntity<Health> healthResponseEntity = restTemplate.getForEntity(url + "/", Health.class);
    assertEquals(healthResponseEntity.getStatusCode(), HttpStatus.OK);
    final Health body = healthResponseEntity.getBody();
    assertTrue(body.isSuccess());
  }
}
