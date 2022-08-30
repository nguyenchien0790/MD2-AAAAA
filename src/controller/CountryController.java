package controller;

import model.Country;
import service.country.CountryServiceIMPL;
import service.country.ICountryService;

import java.util.List;

public class CountryController {
    ICountryService countryService = new CountryServiceIMPL();

    public List<Country> showCountryList(){
        return countryService.findAll();
    }
    public void createCountry(Country country){
        countryService.save(country);
    }
    public Country findCountry(int id){
        return countryService.findById(id);
    }
    public void editCountry(int id, Country newCountryName){
        Country country =countryService.findById(id);
        country.setName(newCountryName.getName());
    }
    public void deleteCountry(int id){
        countryService.remove(id);
    }

}
