package com.sim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class DateConfig {
  @Bean
  public DateFormat dateFormat() {
    return new SimpleDateFormat("yyyy-MM-dd");
  }
}
