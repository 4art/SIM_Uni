package com.sim.module.company.service;

import com.sim.module.company.model.Company;
import com.sim.module.company.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class CompanyServiceImpl implements CompanyService {

  private final CompanyRepo companyRepo;

  @Autowired
  public CompanyServiceImpl(CompanyRepo companyRepo) {
    this.companyRepo = companyRepo;
  }

  @Override
  public Optional<Company> findBySymbolOrName(String symbol, String name) {
    List<Company> companies = new ArrayList<>();
    if (name != null) {
      companies = companyRepo.findByName(name).orElse(new ArrayList<>());
    }
    if (symbol != null) {
      companies = companyRepo.findBySymbol(symbol).orElse(new ArrayList<>());
    }
    if (companies.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(companies.get(0));
  }

  @Override
  public Optional<List<Company>> findAll() {
    return companyRepo.findAll();
  }

  @Override
  public Optional<Company> findById(int id) {
    return companyRepo.findById(id);
  }

  @Override
  public Optional<List<Company>> findBySymbol(String symbol) {
    return companyRepo.findBySymbol(symbol);
  }

  @Override
  public Optional<List<Company>> findByName(String name) {
    return companyRepo.findByName(name);
  }

  @Async
  @Override
  public CompletableFuture<Optional<Company>> findBySymbolOrNameAsync(String symbol, String name) {
    return CompletableFuture.completedFuture(findBySymbolOrName(symbol, name));
  }

  @Async
  @Override
  public CompletableFuture<Optional<List<Company>>> findAllAsync() {
    return CompletableFuture.completedFuture(findAll());
  }

  @Async
  @Override
  public CompletableFuture<Optional<Company>> findByIdAsync(int id) {
    return CompletableFuture.completedFuture(findById(id));
  }

  @Async
  @Override
  public CompletableFuture<Optional<List<Company>>> findBySymbolAsync(String symbol) {
    return CompletableFuture.completedFuture(findBySymbol(symbol));
  }

  @Async
  @Override
  public CompletableFuture<Optional<List<Company>>> findByNameAsync(String name) {
    return CompletableFuture.completedFuture(findByName(name));
  }
}
