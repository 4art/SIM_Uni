package com.sim.module.chart.service;

import com.sim.module.chart.model.ChartData;
import com.sim.module.chart.model.ChartDataStaticDto;
import com.sim.module.chart.model.builder.ChartDataBuilder;
import com.sim.module.chart.model.YahooFin;
import com.sim.module.chart.repo.ChartDataStaticRepo;
import com.sim.module.company.model.Company;
import com.sim.module.company.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Service
public class YahooFinServiceImpl implements YahooFinService {

  private final RestTemplate restTemplate;
  private final String yahooFinURL;
  private final HttpHeaders httpHeaders;
  private final CompanyService companyService;
  private final ChartDataStaticRepo chartDataStaticRepo;

  @Autowired
  public YahooFinServiceImpl(RestTemplate restTemplate, @Value("${service.yahooFin}") String yahooFinURL, HttpHeaders httpHeaders, CompanyService companyService, ChartDataStaticRepo chartDataStaticRepo) {
    this.restTemplate = restTemplate;
    this.yahooFinURL = yahooFinURL;
    this.httpHeaders = httpHeaders;
    this.companyService = companyService;
    this.chartDataStaticRepo = chartDataStaticRepo;
  }

  @Override
  public Optional<List<YahooFin>> getBySymbol(String symbol) {
    final ParameterizedTypeReference<List<YahooFin>> parameterizedTypeReference = new ParameterizedTypeReference<List<YahooFin>>() {
    };
    final ResponseEntity<List<YahooFin>> yahoofinEntity = restTemplate.exchange(yahooFinURL + "/yahoo?symbol=" + symbol, HttpMethod.GET, new HttpEntity<>(httpHeaders), parameterizedTypeReference);
    if (yahoofinEntity.getStatusCode() != HttpStatus.OK) {
      return Optional.empty();
    }
    final List<YahooFin> finLambdas = yahoofinEntity.getBody();
    if (finLambdas.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(finLambdas);
  }

  @Override
  public Optional<Map<String, List<YahooFin>>> getBySymbols(List<String> symbols) {
    final String symbolsAsString = String.join(",", symbols);
    final ParameterizedTypeReference<Map<String, List<YahooFin>>> parameterizedTypeReference = new ParameterizedTypeReference<Map<String, List<YahooFin>>>() {
    };
    final ResponseEntity<Map<String, List<YahooFin>>> yahooFinSymbols = restTemplate.exchange(yahooFinURL + "/yahoo?symbols=" + symbolsAsString, HttpMethod.GET, new HttpEntity<>(httpHeaders), parameterizedTypeReference);
    if (yahooFinSymbols.getStatusCode() != HttpStatus.OK) {
      return Optional.empty();
    }
    final Map<String, List<YahooFin>> finSymbols = yahooFinSymbols.getBody();

    return Optional.of(finSymbols);
  }

  @Override
  public Optional<List<YahooFin>> getByCompanyId(int companyId) {

    return getYahooFinanceLambdaList(companyId);
  }

  @Override
  public Optional<ChartData> getChartData(int companyId) {
    final CompletableFuture<Optional<List<YahooFin>>> byCompanyId = getByCompanyIdAsync(companyId);
    final CompletableFuture<Optional<Company>> company = companyService.findByIdAsync(companyId);
    CompletableFuture.allOf(byCompanyId, company);
    final Optional<List<YahooFin>> yahooFinLambdas = byCompanyId.join();
    final Optional<Company> companyOp = company.join();
    if (!yahooFinLambdas.isPresent() || !companyOp.isPresent())
      return Optional.empty();
    return Optional.of(ChartDataBuilder.aChartData()
        .withChartData(convertToChartData(yahooFinLambdas.get()))
        .withCompany(companyOp.get())
        .build());
  }

  @Async
  public Optional<List<YahooFin>> getYahooFinanceLambdaList(int companyId) {
    final Optional<ChartDataStaticDto> byCompanyId = chartDataStaticRepo.findByCompanyId(companyId);
    if (!byCompanyId.isPresent()) {
      final Optional<List<YahooFin>> yahooFinFromLambdaByCompanyId = getYahooFinFromServiceByCompanyId(companyId);
      yahooFinFromLambdaByCompanyId.ifPresent(yahooFinLambdas -> chartDataStaticRepo.createAsync(yahooFinLambdas, companyId).whenCompleteAsync((yahooFinLambdas1, throwable) -> {
        if (throwable instanceof Exception) {
          throwable.printStackTrace();
        } else {
          log.info(String.format("static data for YahooFin with id %d was created", companyId));
        }
      }));
      return yahooFinFromLambdaByCompanyId;
    } else {
      long diffInMillies = Math.abs(new Date().getTime() - byCompanyId.get().getDate().getTime());
      long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
      if (diff >= 1) {
        final Optional<List<YahooFin>> yahooFinFromLambdaByCompanyId = getYahooFinFromServiceByCompanyId(companyId);
        yahooFinFromLambdaByCompanyId.ifPresent(yahooFinLambdas -> chartDataStaticRepo.updateAsync(yahooFinLambdas, companyId).whenCompleteAsync((yahooFinLambdas1, throwable) -> {
          if (throwable instanceof Exception) {
            throwable.printStackTrace();

          } else {
            log.info(String.format("static data for YahooFin with id %d was updated", companyId));
          }
        }));
        return yahooFinFromLambdaByCompanyId;
      } else {
        return Optional.of(byCompanyId.get().getYahooFins());
      }
    }
  }

  @Async
  @Override
  public CompletableFuture<Optional<Map<String, List<YahooFin>>>> getBySymbolsAsync(List<String> symbol) {
    return CompletableFuture.completedFuture(getBySymbols(symbol));
  }

  @Async
  @Override
  public CompletableFuture<Optional<List<YahooFin>>> getBySymbolAsync(String symbol) {
    return CompletableFuture.completedFuture(getBySymbol(symbol));
  }

  @Async
  @Override
  public CompletableFuture<Optional<List<YahooFin>>> getByCompanyIdAsync(int companyId) {
    return CompletableFuture.completedFuture(getByCompanyId(companyId));
  }

  private List<List<Number>> convertToChartData(List<YahooFin> yahooFinLambdas) {
    return yahooFinLambdas.stream().map(yahooFinLambda -> Arrays.asList(yahooFinLambda.getDate().getTime(), yahooFinLambda.getClose())).collect(Collectors.toList());
  }

  private Optional<List<YahooFin>> getYahooFinFromServiceByCompanyId(int companyId) {
    final Optional<Company> company = companyService.findById(companyId);
    if (!company.isPresent()) {
      return Optional.empty();
    }
    return getBySymbol(company.get().getSymbol());
  }
}
