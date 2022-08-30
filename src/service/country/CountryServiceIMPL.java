package service.country;

import config.Config;
import model.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryServiceIMPL implements ICountryService{
    static String PATH_COUNTRY = "src/database/country.txt";
    static Config<List<Country>> config = new Config<>();
    static List<Country> countryList = config.read(PATH_COUNTRY);

    static {
        if (countryList == null) {
            countryList = new ArrayList<>();
        }
    }

    @Override
    public List<Country> findAll() {
        updateData();
        return countryList;
    }

    @Override
    public void save(Country country) {
        countryList.add(country);
        updateData();

    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < countryList.size(); i++) {
            if (id == countryList.get(i).getId()) {
                countryList.remove(i);

            }

        }

    }

    @Override
    public Country findById(int id) {
        for (int i = 0; i < countryList.size(); i++) {
            if (id == countryList.get(i).getId()) {
                return countryList.get(i);
            }
        }
        return null;
    }

    @Override
    public void updateData() {
        config.write(PATH_COUNTRY, countryList);

    }

    @Override
    public int getLastId() {
        return 0;
    }
}
