package com.sim.module.company.service;

import com.sim.module.company.model.Company;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface CompanyService {
  Optional<Company> findBySymbolOrName(String symbol, String name);

  Optional<List<Company>> findAll();

  Optional<Company> findById(int id);

  Optional<List<Company>> findBySymbol(String symbol);

  Optional<List<Company>> findByName(String name);

  CompletableFuture<Optional<Company>> findBySymbolOrNameAsync(String symbol, String name);

  CompletableFuture<Optional<List<Company>>> findAllAsync();

  CompletableFuture<Optional<Company>> findByIdAsync(int id);

  CompletableFuture<Optional<List<Company>>> findBySymbolAsync(String symbol);

  CompletableFuture<Optional<List<Company>>> findByNameAsync(String name);
}
