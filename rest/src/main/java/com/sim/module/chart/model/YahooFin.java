package com.sim.module.chart.model;

import java.util.Date;

public class YahooFin {
  private Date date;
  private Number open;
  private Number high;
  private Number low;
  private Number close;
  private Number adjClose;
  private Number volume;
  private String symbol;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Number getOpen() {
    return open;
  }

  public void setOpen(Number open) {
    this.open = open;
  }

  public Number getHigh() {
    return high;
  }

  public void setHigh(Number high) {
    this.high = high;
  }

  public Number getLow() {
    return low;
  }

  public void setLow(Number low) {
    this.low = low;
  }

  public Number getClose() {
    return close;
  }

  public void setClose(Number close) {
    this.close = close;
  }

  public Number getAdjClose() {
    return adjClose;
  }

  public void setAdjClose(Number adjClose) {
    this.adjClose = adjClose;
  }

  public Number getVolume() {
    return volume;
  }

  public void setVolume(Number volume) {
    this.volume = volume;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return "YahooFinLambda{" +
        "date=" + date +
        ", open=" + open +
        ", high=" + high +
        ", low=" + low +
        ", close=" + close +
        ", adjClose=" + adjClose +
        ", volume=" + volume +
        ", symbol='" + symbol + '\'' +
        '}';
  }
}
