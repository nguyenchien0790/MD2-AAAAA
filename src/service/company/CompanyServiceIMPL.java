package service.company;

import config.Config;
import model.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyServiceIMPL implements ICompanyService{
    static String PATH_COMPANY="src/database/company.txt";
    static Config<List<Company>> config = new Config<>();
    static List<Company> companyList = config.read(PATH_COMPANY);
    static {
        if (companyList == null){
            companyList = new ArrayList<>();
        }
    }




    @Override
    public List<Company> findAll() {
        return companyList;
    }

    @Override
    public void save(Company company) {
        companyList.add(company);

    }

    @Override
    public void remove(int id) {
        for (Company company: companyList ) {
            if (id == company.getId()){
                companyList.remove(company);
                break;
            }
        }
        updateData();
    }

    @Override
    public Company findById(int id) {
        for (Company company:companyList) {
            if (id == company.getId()){
             return company;
            }
        }
        return null;
    }

    @Override
    public void updateData() {
        config.write(PATH_COMPANY,companyList);
    }

    @Override
    public int getLastId() {
        return 0;
    }
}
