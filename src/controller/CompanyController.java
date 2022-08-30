package controller;

import model.Company;
import service.company.CompanyServiceIMPL;
import service.company.ICompanyService;

import java.util.List;

public class CompanyController {
    ICompanyService companyService = new CompanyServiceIMPL();

    public List<Company> showCompanyList(){
        return companyService.findAll();
    }
    public void createCompany(Company company){
        companyService.save(company);
    }
    public void updateCompany(int id , Company newCompany){
        Company company =companyService.findById(id);
        company.setCompanyName(newCompany.getCompanyName());
    }
    public void deleteCompany(int id){
        companyService.remove(id);

    }

    public Company detailCompany(int id){
        return companyService.findById(id);
    }


}
