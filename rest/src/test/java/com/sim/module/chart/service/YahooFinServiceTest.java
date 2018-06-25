package com.sim.module.chart.service;

import com.sim.IntegrationTest;
import com.sim.module.chart.model.YahooFin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class YahooFinServiceTest extends IntegrationTest {

  @Autowired
  private YahooFinService yahooFinService;

  @Test
  public void getBySymbol() {
    final Optional<List<YahooFin>> bySymbol = yahooFinService.getBySymbol(colaCom.getSymbol());
    assertTrue(bySymbol.isPresent());
    bySymbol.ifPresent(yahooFins -> yahooFins.forEach(yahooFin -> assertEquals(yahooFin.getSymbol(), colaCom.getSymbol())));
  }

  @Test
  public void getBySymbols() {
    final Optional<Map<String, List<YahooFin>>> bySymbols = yahooFinService.getBySymbols(Arrays.asList(colaCom.getSymbol(), nkeCom.getSymbol()));
    assertTrue(bySymbols.isPresent());
    bySymbols.ifPresent(stringListMap -> {
      assertFalse(stringListMap.get(colaCom.getSymbol()).isEmpty());
      stringListMap.get(colaCom.getSymbol()).forEach(yahooFinLambda -> assertEquals(yahooFinLambda.getSymbol(), colaCom.getSymbol()));
      assertFalse(stringListMap.get(nkeCom.getSymbol()).isEmpty());
      stringListMap.get(nkeCom.getSymbol()).forEach(yahooFinLambda -> assertEquals(yahooFinLambda.getSymbol(), nkeCom.getSymbol()));
    });
  }

  @Test
  public void getByCompanyId() {
    final Optional<List<YahooFin>> byCompanyId = yahooFinService.getByCompanyId(colaCom.getId());
    assertTrue(byCompanyId.isPresent());
    byCompanyId.ifPresent(yahooFinLambdas -> {
      assertFalse(yahooFinLambdas.isEmpty());
      yahooFinLambdas.forEach(yahooFinLambda -> assertEquals(yahooFinLambda.getSymbol(), colaCom.getSymbol()));
    });
  }
}
