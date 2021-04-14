package br.com.symbiosyssolucoes.PharmaIntegration.controllers;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Company;
import br.com.symbiosyssolucoes.PharmaIntegration.services.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CompanyController {

    CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @PostMapping("/company/new")
    public ResponseEntity<Company> insertCompany(@RequestBody Company company){
        System.out.println(company);
        Company inserted =  this.companyService.insertCompany(company);

        return ResponseEntity.ok(inserted);

    }
}
