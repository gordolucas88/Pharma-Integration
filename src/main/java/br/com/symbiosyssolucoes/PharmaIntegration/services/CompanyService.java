package br.com.symbiosyssolucoes.PharmaIntegration.services;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Company;
import br.com.symbiosyssolucoes.PharmaIntegration.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    private void insertCompany(Company company){

        this.companyRepository.save(company);

    }

    private Optional<Company> listCompanyById(Long id){

        Optional<Company> company = this.companyRepository.findById(id);

        return company;

    }

    private Optional<List<Company>> listCompanies(){

        Optional<List<Company>> companies = Optional.ofNullable(this.companyRepository.findAll());

        return companies;


    }

}
