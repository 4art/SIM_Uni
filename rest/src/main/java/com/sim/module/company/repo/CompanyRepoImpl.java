package com.sim.module.company.repo;

import com.sim.module.company.model.Company;
import com.sim.module.company.model.builder.CompanyBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CompanyRepoImpl implements CompanyRepo {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public CompanyRepoImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Optional<List<Company>> findAll() {
    final String sql = "SELECT * FROM sim.company WHERE name IS NOT NULL AND symbol IS NOT NULL ORDER BY name";
    try {
      return Optional.of(jdbcTemplate.queryForList(sql).stream().map(this::convertMapToCompany).collect(Collectors.toList()));
    } catch (EmptyResultDataAccessException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  @Override
  public Optional<Company> findById(int id) {
    final String sql = "SELECT * FROM sim.company WHERE id = ?";
    try {
      return Optional.ofNullable(convertMapToCompany(jdbcTemplate.queryForMap(sql, id)));
    } catch (EmptyResultDataAccessException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  @Override
  public Optional<List<Company>> findBySymbol(String symbol) {
    final String sql = "SELECT * FROM sim.company WHERE LOWER(symbol) LIKE LOWER(?)";
    return getCompaniesFindByLike(symbol, sql);
  }

  @Override
  public Optional<List<Company>> findByName(String name) {
    final String sql = "SELECT * FROM sim.company WHERE LOWER(name) LIKE LOWER(?)";
    return getCompaniesFindByLike(name, sql);
  }

  private Optional<List<Company>> getCompaniesFindByLike(String name, String sql) {
    try {
      final List<Company> collect = jdbcTemplate.queryForList(sql, String.format("%s%%", name)).stream().map(this::convertMapToCompany).collect(Collectors.toList());
      return collect.isEmpty() ? Optional.empty() : Optional.of(collect);
    } catch (EmptyResultDataAccessException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  private Company convertMapToCompany(Map<String, Object> comMap) {
    return CompanyBuilder.aCompany()
        .withId(comMap.get("id") != null ? (Integer) comMap.get("id") : null)
        .withName(comMap.get("name") != null ? (String) comMap.get("name") : null)
        .withSymbol(comMap.get("symbol") != null ? (String) comMap.get("symbol") : null)
        .build();
  }
}
