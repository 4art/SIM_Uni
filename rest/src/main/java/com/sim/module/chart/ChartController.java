package com.sim.module.chart;

import com.sim.module.chart.model.ChartData;
import com.sim.module.chart.service.YahooFinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/stock")
public class ChartController {

  private final YahooFinService yahooFinanceService;

  @Autowired
  public ChartController(YahooFinService yahooFinanceService) {
    this.yahooFinanceService = yahooFinanceService;
  }

  @GetMapping("/chartData/{companyId}")
  public ResponseEntity<ChartData> getChartData(@PathVariable("companyId") int companyId) {
    final Optional<ChartData> chartData = yahooFinanceService.getChartData(companyId);
    if (chartData.isPresent()) {
      return ResponseEntity.ok(chartData.get());
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
