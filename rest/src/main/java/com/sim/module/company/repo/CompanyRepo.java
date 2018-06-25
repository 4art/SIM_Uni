package com.sim.module.company.repo;

import com.sim.module.company.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepo {
  Optional<List<Company>> findAll();
  Optional<Company> findById(int id);
  Optional<List<Company>> findBySymbol(String symbol);
  Optional<List<Company>> findByName(String name);
}
