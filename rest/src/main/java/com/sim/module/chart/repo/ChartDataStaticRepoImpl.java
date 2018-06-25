package com.sim.module.chart.repo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sim.module.chart.model.ChartDataStaticDto;
import com.sim.module.chart.model.YahooFin;
import com.sim.module.chart.model.builder.ChartDataStaticDtoBuilder;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Repository
public class ChartDataStaticRepoImpl implements ChartDataStaticRepo {
  private final JdbcTemplate jdbcTemplate;
  private final DateFormat dateFormat;
  private final ObjectMapper objectMapper;

  @Autowired
  public ChartDataStaticRepoImpl(JdbcTemplate jdbcTemplate, DateFormat dateFormat, ObjectMapper objectMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.dateFormat = dateFormat;
    this.objectMapper = objectMapper;
  }

  @Override
  public Optional<List<ChartDataStaticDto>> findAll() {
    final String sql = "SELECT * FROM sim.chart_data";
    try {
      return Optional.of(jdbcTemplate.queryForList(sql).stream().map(this::convertMapToChartDataStatic).collect(Collectors.toList()));
    } catch (EmptyResultDataAccessException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }


  @Override
  public Optional<List<YahooFin>> create(List<YahooFin> yahooFinLambdas, int companyId) {
    final String sql = "INSERT INTO sim.chart_data (company_id, data) VALUES (?, ?::JSON)";
    try {
      jdbcTemplate.update(sql, companyId, objectMapper.writeValueAsString(yahooFinLambdas));
      return Optional.of(yahooFinLambdas);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  @Override
  public Optional<List<YahooFin>> update(List<YahooFin> yahooFinLambdas, int companyId) {
    final String sql = "UPDATE sim.chart_data SET data = ?::JSON, datetime = ?::TIMESTAMP WHERE company_id = ?";
    try {
      jdbcTemplate.update(sql, objectMapper.writeValueAsString(yahooFinLambdas), dateFormat.format(new Date()), companyId);
      return Optional.of(yahooFinLambdas);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  @Override
  public CompletableFuture<Optional<List<YahooFin>>> createAsync(List<YahooFin> yahooFinLambdas, int companyId) {
    return CompletableFuture.completedFuture(create(yahooFinLambdas, companyId));
  }

  @Override
  public CompletableFuture<Optional<List<YahooFin>>> updateAsync(List<YahooFin> yahooFinLambdas, int companyId) {
    return CompletableFuture.completedFuture(update(yahooFinLambdas, companyId));
  }


  @Override
  public Optional<ChartDataStaticDto> findByCompanyId(int companyId) {
    final String sql = "SELECT * FROM sim.chart_data WHERE company_id = ?";
    try {
      return Optional.ofNullable(convertMapToChartDataStatic(jdbcTemplate.queryForMap(sql, companyId)));
    } catch (EmptyResultDataAccessException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  private ChartDataStaticDto convertMapToChartDataStatic(Map<String, Object> stringObjectMap) {
    final PGobject data = (PGobject) stringObjectMap.get("data");
    try {
      return ChartDataStaticDtoBuilder.aChartDataStatic()
          .withId(stringObjectMap.get("id") == null ? null : (Integer) stringObjectMap.get("id"))
          .withCompanyId(stringObjectMap.get("company_id") == null ? null : (Integer) stringObjectMap.get("company_id"))
          .withDate(stringObjectMap.get("datetime") == null ? null : new Date(((Timestamp) stringObjectMap.get("datetime")).getTime()))
          .withYahooFins(data.getValue() == null ? null : objectMapper.readValue(data.getValue(), new TypeReference<List<YahooFin>>() {
          }))
          .build();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
