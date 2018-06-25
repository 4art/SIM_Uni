package com.sim.module.chart.model;

import com.sim.module.company.model.Company;

import java.util.List;

public class ChartData {
  private Company company;
  private List<List<Number>> chartData;

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public List<List<Number>> getChartData() {
    return chartData;
  }

  public void setChartData(List<List<Number>> chartData) {
    this.chartData = chartData;
  }

  @Override
  public String toString() {
    return "ChartData{" +
        "company=" + company +
        ", chartData=" + chartData +
        '}';
  }
}
