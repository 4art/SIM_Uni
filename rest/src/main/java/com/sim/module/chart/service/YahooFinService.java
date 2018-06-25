package com.sim.module.chart.service;

import com.sim.module.chart.model.ChartData;
import com.sim.module.chart.model.YahooFin;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface YahooFinService {
  Optional<List<YahooFin>> getBySymbol(String symbol);

  Optional<Map<String, List<YahooFin>>> getBySymbols(List<String> symbol);

  Optional<List<YahooFin>> getByCompanyId(int companyId);

  Optional<ChartData> getChartData(int companyId);

  CompletableFuture<Optional<Map<String, List<YahooFin>>>> getBySymbolsAsync(List<String> symbol);

  CompletableFuture<Optional<List<YahooFin>>> getBySymbolAsync(String symbol);

  CompletableFuture<Optional<List<YahooFin>>> getByCompanyIdAsync(int companyId);
}
