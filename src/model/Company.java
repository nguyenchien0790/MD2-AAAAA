package model;

import java.io.Serializable;

public class Company implements Serializable {
    private int id;
    private String companyName;

    public Company() {
    }

    public Company(String newCompanyName) {
    }

    public Company(int id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "CompanyController { " +
                "id = " + id +
                ", companyName = '" + companyName + '\'' +
                '}';
    }
}
