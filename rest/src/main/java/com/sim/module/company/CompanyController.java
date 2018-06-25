package com.sim.module.company;

import com.sim.module.company.model.Company;
import com.sim.module.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {

  @Autowired
  private CompanyService companyService;

  @RequestMapping(value = "/company", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<List<Company>> findAllCompanies() {
    final Optional<List<Company>> companies = companyService.findAll();
    if (companies.isPresent()) {
      return ResponseEntity.ok(companies.get());
    }
    return ResponseEntity.ok(new ArrayList<>());
  }

  @RequestMapping(value = "/company/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Company> findCompanyById(@PathVariable int id) {
    final Optional<Company> company = companyService.findById(id);
    if (company.isPresent()) {
      return ResponseEntity.ok(company.get());
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value = "/company/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<List<Company>> findCompanyBySymbol(@RequestParam(value = "symbol", required = false) String symbol, @RequestParam(value = "name", required = false) String name) {
    List<Company> companies = new ArrayList<>();
    if (name != null) {
      companies = companyService.findByName(name).orElse(new ArrayList<>());
    }
    if (symbol != null) {
      companies = companyService.findBySymbol(symbol).orElse(new ArrayList<>());
    }
    if (companies.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(companies);
  }
}
