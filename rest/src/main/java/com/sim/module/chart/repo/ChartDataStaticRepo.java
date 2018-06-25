package com.sim.module.chart.repo;

import com.sim.module.chart.model.ChartDataStaticDto;
import com.sim.module.chart.model.YahooFin;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface ChartDataStaticRepo {
  Optional<List<ChartDataStaticDto>> findAll();

  Optional<List<YahooFin>> create(List<YahooFin> yahooFinLambdas, int companyId);

  Optional<List<YahooFin>> update(List<YahooFin> yahooFinLambdas, int companyId);

  CompletableFuture<Optional<List<YahooFin>>> createAsync(List<YahooFin> yahooFinLambdas, int companyId);

  CompletableFuture<Optional<List<YahooFin>>> updateAsync(List<YahooFin> yahooFinLambdas, int companyId);

  Optional<ChartDataStaticDto> findByCompanyId(int companyId);
}
