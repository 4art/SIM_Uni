package com.sim;

import com.sim.module.company.model.Company;
import com.sim.module.company.model.builder.CompanyBuilder;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public abstract class IntegrationTest {
  @LocalServerPort
  private int port;

  protected final Company colaCom = CompanyBuilder.aCompany()
      .withId(21344)
      .withName("COCA COLA CO")
      .withSymbol("KO")
      .build();

  protected final Company nkeCom = CompanyBuilder.aCompany()
      .withId(320187)
      .withName("NIKE INC")
      .withSymbol("NKE")
      .build();

  protected String url;

  private final String AUTH_KEY = "Authorization";
  private final String VALID_HEADER = "Basic Zmlyc292LnR5b21hQGdtYWlsLmNvbTohYXJ0ZW0uLg==";
  private final String INVALID_HEADER = "Basic Zmlyc292LnR5b21hQGdtYWlsLmNvbTohYXJ0Z";

  @Autowired
  protected RestTemplate restTemplate;

  protected HttpHeaders getValidHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add(AUTH_KEY, VALID_HEADER);
    return headers;
  }

  protected HttpHeaders getInvalidHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add(AUTH_KEY, INVALID_HEADER);
    return headers;
  }



  @Before
  public void initUrl() {
    url = String.format("http://localhost:%d", port);
  }
}
