package com.sim.module.chart.model;

import java.util.Date;
import java.util.List;

public class ChartDataStaticDto {
  private Integer id;
  private Integer companyId;
  private List<YahooFin> yahooFinLambdas;
  private Date date;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCompanyId() {
    return companyId;
  }

  public void setCompanyId(int companyId) {
    this.companyId = companyId;
  }

  public List<YahooFin> getYahooFins() {
    return yahooFinLambdas;
  }

  public void setYahooFins(List<YahooFin> yahooFinLambdas) {
    this.yahooFinLambdas = yahooFinLambdas;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "ChartDataStatic{" +
        "id=" + id +
        ", companyId=" + companyId +
        ", yahooFinLambdas=" + yahooFinLambdas +
        ", date=" + date +
        '}';
  }

}
