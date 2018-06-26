package com.sim.module.transaction;

import com.sim.IntegrationTest;
import com.sim.module.transaction.model.Transaction;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.*;

public class TransactionControllerTest extends IntegrationTest {

  @Test
  public void findTransactionsByCompanyId() {
    final ParameterizedTypeReference<List<Transaction>> companyParameterizedTypeReference = new ParameterizedTypeReference<List<Transaction>>() {
    };
    final ResponseEntity<List<Transaction>> transactionEntity = restTemplate.exchange(url + "/transactions/" + colaCom.getId(), HttpMethod.GET, new HttpEntity<>(getValidHeaders()), companyParameterizedTypeReference);
    assertEquals(transactionEntity.getStatusCode(), HttpStatus.OK);
    assertFalse(transactionEntity.getBody().isEmpty());
    transactionEntity.getBody().forEach(transaction -> {
      assertNotNull(transaction.getTransactionInfo().getTransactionType());
      assertNotEquals(transaction.getInsider().getRelation().getOfficerTitle(), "");
    });
  }
}
