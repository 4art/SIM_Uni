package com.sim.module.chart.model.builder;

import com.sim.module.chart.model.ChartDataStaticDto;
import com.sim.module.chart.model.YahooFin;

import java.util.Date;
import java.util.List;

public final class ChartDataStaticDtoBuilder {
  private int id;
  private int companyId;
  private List<YahooFin> yahooFinLambdas;
  private Date date;

  private ChartDataStaticDtoBuilder() {
  }

  public static ChartDataStaticDtoBuilder aChartDataStatic() {
    return new ChartDataStaticDtoBuilder();
  }

  public ChartDataStaticDtoBuilder withId(int id) {
    this.id = id;
    return this;
  }

  public ChartDataStaticDtoBuilder withCompanyId(int companyId) {
    this.companyId = companyId;
    return this;
  }

  public ChartDataStaticDtoBuilder withYahooFins(List<YahooFin> yahooFinLambdas) {
    this.yahooFinLambdas = yahooFinLambdas;
    return this;
  }

  public ChartDataStaticDtoBuilder withDate(Date date) {
    this.date = date;
    return this;
  }

  public ChartDataStaticDto build() {
    ChartDataStaticDto chartDataStatic = new ChartDataStaticDto();
    chartDataStatic.setId(id);
    chartDataStatic.setCompanyId(companyId);
    chartDataStatic.setYahooFins(yahooFinLambdas);
    chartDataStatic.setDate(date);
    return chartDataStatic;
  }
}
