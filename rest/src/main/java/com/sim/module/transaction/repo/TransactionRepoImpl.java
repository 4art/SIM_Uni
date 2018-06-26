package com.sim.module.transaction.repo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sim.module.transaction.model.Transaction;
import com.sim.module.transaction.model.TransactionCode;
import com.sim.module.transaction.model.TransactionType;
import com.sim.module.transaction.model.builder.TransactionTypeBuilder;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Repository
public class TransactionRepoImpl implements TransactionRepo {

  private final JdbcTemplate jdbcTemplate;
  private final ObjectMapper objectMapper;

  @Autowired
  public TransactionRepoImpl(JdbcTemplate jdbcTemplate, ObjectMapper objectMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.objectMapper = objectMapper;
  }

  @Override
  public Optional<List<Transaction>> findByCompanyId(int companyId) {
    final String sql = "SELECT json_build_object( " +
        "           'insider', json_build_object( " +
        "               'id', i.id, " +
        "               'name', i.name, " +
        "               'addresses', (SELECT array_to_json(array_agg(row_to_json(address))) " +
        "                             FROM (SELECT " +
        "                                     ia.country, " +
        "                                     ia.city, " +
        "                                     ia.state, " +
        "                                     ia.name, " +
        "                                     ia.street, " +
        "                                     ia.zip, " +
        "                                     ia.description " +
        "                                   FROM sim.insider_address ia " +
        "                                     INNER JOIN sim.insider_to_address ita " +
        "                                       ON ita.insider_address_id = ia.id AND ita.insider_id = i.id) address), " +
        "               'company', (SELECT json_build_object( " +
        "                   'id', c.id, " +
        "                   'name', c.name, " +
        "                   'symbol', c.symbol " +
        "               ) " +
        "                           FROM sim.company c " +
        "                           WHERE c.id = itc.company_id), " +
        "               'relation', (SELECT json_build_object( " +
        "                   'other', ir.other, " +
        "                   'officer', ir.officer, " +
        "                   'director', ir.director, " +
        "                   'tenPercentOwner', ir.ten_percent_owner, " +
        "                   'officerTitle', ir.oficer_titel " +
        "               ) " +
        "                            FROM sim.insider_relation ir " +
        "                            WHERE ir.insider_id = i.id AND " +
        "                                  ir.company_id = itc.company_id " +
        "               ) " +
        "           ), " +
        "           'transactionInfo', json_build_object( " +
        "               'security', ti.security, " +
        "               'shares', ti.shares, " +
        "               'price', ti.price, " +
        "               'currency', ti.currency, " +
        "               'valueUSD', ti.value_usd, " +
        "               'holding', ti.holding, " +
        "               'transactionType', ( " +
        "                 SELECT json_build_object( " +
        "                     'code', tt.code, " +
        "                     'label', tt.label, " +
        "                     'description', tt.description " +
        "                 ) " +
        "                 FROM sim.transactions_type tt " +
        "                 WHERE tt.code = ti.code " +
        "               ), " +
        "               'date', ti.date " +
        "           ) " +
        "       ) json " +
        "FROM sim.insider i " +
        "  INNER JOIN sim.insider_to_company itc ON i.id = itc.insider_id " +
        "  INNER JOIN sim.transaction_info ti ON ti.company_id = itc.company_id AND ti.insider_id = i.id " +
        "WHERE itc.company_id = ?";
    try {
      return Optional.of(jdbcTemplate.queryForList(sql, companyId).stream().map(this::convertMapToTransaction).collect(Collectors.toList()));
    } catch (EmptyResultDataAccessException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  private Transaction convertMapToTransaction(Map<String, Object> stringObjectMap) {
    try {
      final PGobject pgObject = (PGobject) stringObjectMap.get("json");
      String json = pgObject.getValue();
      final Transaction transaction = objectMapper.readValue(json, Transaction.class);
      return transaction;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Async
  @Override
  public CompletableFuture<Optional<List<Transaction>>> findByCompanyIdAsync(int companyId) {
    return CompletableFuture.completedFuture(findByCompanyId(companyId));
  }

  @Override
  public Optional<List<TransactionType>> findAllTransactionTypes() {
    final String sql = "SELECT * FROM sim.transactions_type";
    try {
      return Optional.of(jdbcTemplate.queryForList(sql).stream().map(this::convertMapToTransactionType).collect(Collectors.toList()));
    } catch (EmptyResultDataAccessException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  private TransactionType convertMapToTransactionType(Map<String, Object> stringObjectMap) {
    return TransactionTypeBuilder.aTransactionType()
        .withCode(TransactionCode.valueOf(stringObjectMap.get("code").toString().toUpperCase()))
        .withDescription(String.valueOf(stringObjectMap.get("description")))
        .withLabel(String.valueOf(stringObjectMap.get("label")))
        .build();
  }

  @Async
  @Override
  public CompletableFuture<Optional<List<TransactionType>>> findAllTransactionTypesAsync() {
    return CompletableFuture.completedFuture(findAllTransactionTypes());
  }
}
