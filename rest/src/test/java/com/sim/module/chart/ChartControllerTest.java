package com.sim.module.chart;

import com.sim.IntegrationTest;
import com.sim.module.chart.model.ChartData;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

public class ChartControllerTest extends IntegrationTest {

  @Test
  public void getChartData() {
    final ParameterizedTypeReference<ChartData> parameterizedTypeReference = new ParameterizedTypeReference<ChartData>() {
    };
    final ResponseEntity<ChartData> chartDataEntity = restTemplate.exchange(url + "/stock/chartData/" + colaCom.getId(), HttpMethod.GET, new HttpEntity<>(getValidHeaders()), parameterizedTypeReference);
    assertEquals(chartDataEntity.getStatusCode(), HttpStatus.OK);
    final ChartData chartData = chartDataEntity.getBody();
    assertFalse(chartData.getChartData().isEmpty());
    assertEquals(colaCom.getId(), chartData.getCompany().getId());
  }
}
