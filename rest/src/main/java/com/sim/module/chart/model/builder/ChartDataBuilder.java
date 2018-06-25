package com.sim.module.chart.model.builder;

import com.sim.module.chart.model.ChartData;
import com.sim.module.company.model.Company;

import java.util.List;

public final class ChartDataBuilder {
  private Company company;
  private List<List<Number>> chartData;

  private ChartDataBuilder() {
  }

  public static ChartDataBuilder aChartData() {
    return new ChartDataBuilder();
  }

  public ChartDataBuilder withCompany(Company company) {
    this.company = company;
    return this;
  }

  public ChartDataBuilder withChartData(List<List<Number>> chartData) {
    this.chartData = chartData;
    return this;
  }

  public ChartData build() {
    ChartData chartData = new ChartData();
    chartData.setCompany(company);
    chartData.setChartData(this.chartData);
    return chartData;
  }
}
