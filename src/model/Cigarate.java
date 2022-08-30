package model;

import java.io.Serializable;

public class Cigarate implements Serializable, Comparable<Cigarate> {
    private int id;

    private String nameCigarate;
    private Country country;
    private Company company;
    private int price;
    private int amount;

    public Cigarate() {
    }

    public Cigarate(int id, String nameCigarate, Country country, Company company, int price, int amount) {
        this.id = id;
        this.nameCigarate = nameCigarate;
        this.country = country;
        this.company = company;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCigarate() {
        return nameCigarate;
    }

    public void setNameCigarate(String nameCigarate) {
        this.nameCigarate = nameCigarate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Cigarate { " +
                " id = " + id +
                ", nameCigarate = '" + nameCigarate + '\'' +
                ", country = " + country +
                ", company = " + company +
                ", price = " + price +
                ", amount = " + amount +
                '}';
    }

    @Override
    public int compareTo(Cigarate cigarate) {
        int temp = this.getPrice()-cigarate.getPrice();
        if (temp!=0){
            return temp;
        }
        temp = this.getNameCigarate().compareTo(cigarate.getNameCigarate());
        return temp;
    }
}
