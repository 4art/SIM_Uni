package com.sim.module.company;

import com.sim.IntegrationTest;
import com.sim.module.company.model.Company;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.*;

public class CompanyControllerTest extends IntegrationTest {

  @Test
  public void findAllCompanies() {
    final ParameterizedTypeReference<List<Company>> companyParameterizedTypeReference = new ParameterizedTypeReference<List<Company>>() {
    };
    final ResponseEntity<List<Company>> compnayEntity = restTemplate.exchange(url + "/company", HttpMethod.GET, new HttpEntity<>(getValidHeaders()), companyParameterizedTypeReference);
    assertEquals(compnayEntity.getStatusCode(), HttpStatus.OK);
    assertFalse(compnayEntity.getBody().isEmpty());
    compnayEntity.getBody().forEach(System.out::println);
  }

  @Test
  public void findCompanyById() {
    final ParameterizedTypeReference<Company> companyParameterizedTypeReference = new ParameterizedTypeReference<Company>() {
    };
    final ResponseEntity<Company> colaEntity = restTemplate.exchange(url + "/company/" + colaCom.getId(), HttpMethod.GET, new HttpEntity<>(getValidHeaders()), companyParameterizedTypeReference);
    assertEquals(colaEntity.getStatusCode(), HttpStatus.OK);
    final Company cola = colaEntity.getBody();
    assertNotNull(cola);
    assertEquals(cola.getId(), colaCom.getId());
    assertEquals(cola.getSymbol(), colaCom.getSymbol());
    assertEquals(cola.getName(), colaCom.getName());
  }

  @Test
  public void findCompanyBySymbol() {
    final ParameterizedTypeReference<List<Company>> companyParameterizedTypeReference = new ParameterizedTypeReference<List<Company>>() {
    };
    final ResponseEntity<List<Company>> colaEntity = restTemplate.exchange(url + "/company/find?symbol=" + colaCom.getSymbol(), HttpMethod.GET, new HttpEntity<>(getValidHeaders()), companyParameterizedTypeReference);
    assertEquals(colaEntity.getStatusCode(), HttpStatus.OK);
    final List<Company> body = colaEntity.getBody();
    assertFalse(body.isEmpty());
  }

  @Test
  public void findCompanyByName() {
    final ParameterizedTypeReference<List<Company>> companyParameterizedTypeReference = new ParameterizedTypeReference<List<Company>>() {
    };
    final ResponseEntity<List<Company>> colaEntity = restTemplate.exchange(url + "/company/find?name=coca", HttpMethod.GET, new HttpEntity<>(getValidHeaders()), companyParameterizedTypeReference);
    assertEquals(colaEntity.getStatusCode(), HttpStatus.OK);
    final List<Company> body = colaEntity.getBody();
    assertFalse(body.isEmpty());
  }


}
