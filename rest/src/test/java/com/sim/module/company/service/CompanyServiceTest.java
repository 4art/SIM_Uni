package com.sim.module.company.service;

import com.sim.IntegrationTest;
import com.sim.module.company.model.Company;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class CompanyServiceTest extends IntegrationTest {

  @Autowired
  private CompanyService companyService;

  @Test
  public void findBySymbolOrName() {
    final Optional<Company> bySymbolOrName = companyService.findBySymbolOrName(colaCom.getSymbol(), colaCom.getName());
    assertTrue(bySymbolOrName.isPresent());
    bySymbolOrName.ifPresent(company -> assertEquals(colaCom.getId(), company.getId()));
  }

  @Test
  public void findAll() {
    final Optional<List<Company>> all = companyService.findAll();
    assertTrue(all.isPresent());
    all.ifPresent(companies -> assertFalse(companies.isEmpty()));
  }

  @Test
  public void findById() {
    final Optional<Company> byId = companyService.findById(colaCom.getId());
    assertTrue(byId.isPresent());
    byId.ifPresent(company -> assertEquals(company.getId(), colaCom.getId()));
  }

  @Test
  public void findBySymbol() {
    final Optional<List<Company>> bySymbol = companyService.findBySymbol(colaCom.getSymbol());
    assertTrue(bySymbol.isPresent());
    bySymbol.ifPresent(companies -> {
      assertFalse(companies.isEmpty());
      assertEquals(companies.get(0).getId(), colaCom.getId());
    });
  }

  @Test
  public void findByName() {
    final Optional<List<Company>> byName = companyService.findByName(colaCom.getName());
    assertTrue(byName.isPresent());
    byName.ifPresent(companies -> {
      assertFalse(companies.isEmpty());
      assertEquals(companies.get(0).getId(), colaCom.getId());
    });
  }
}
