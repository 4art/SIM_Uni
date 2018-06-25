package com.sim.module.transaction.repo;

import com.sim.module.transaction.model.Transaction;
import com.sim.module.transaction.model.TransactionType;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Repository
public class TransactionRepoImpl implements TransactionRepo {

  private final JdbcTemplate jdbcTemplate;

  public TransactionRepoImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Optional<List<Transaction>> findByCompanyId(int companyId) {
    final String sql = "SELECT * FROM sim.company WHERE name IS NOT NULL AND symbol IS NOT NULL ORDER BY name";
    try {
      return Optional.of(jdbcTemplate.queryForList(sql).stream().map(this::convertMapToTransaction).collect(Collectors.toList()));
    } catch (EmptyResultDataAccessException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  @Override
  public CompletableFuture<Optional<List<Transaction>>> findByCompanyIdAsync(int companyId) {
    return null;
  }

  @Override
  public Optional<List<TransactionType>> findAllTransactionTypes() {
    return Optional.empty();
  }

  @Override
  public CompletableFuture<Optional<List<TransactionType>>> findAllTransactionTypesAsync() {
    return null;
  }
}
