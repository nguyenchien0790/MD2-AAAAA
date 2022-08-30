package view;

import config.Config;
import controller.CountryController;
import model.Country;

import java.util.List;

public class ViewCountry {
    CountryController countryController = new CountryController();
    List<Country> countryList = countryController.showCountryList();

    public void countryMenu(){
        System.out.println("******COUNTRY MANAGE******");
        System.out.println("1. Show list country");
        System.out.println("2. Create country");
        System.out.println("3. Update country");
        System.out.println("4. Delete cuontry");
        System.out.println("5. Back menu");
        int choice = Config.getValidInteger();
        switch (choice){
            case 1:
                formGetCountryList();
                break;
            case 2:
                formCreatCountry();
                break;
            case 3:
                formEditCountry();
                break;
            case 4:
                formDeleteCountry();
                break;
            case 5:
                new ViewHome();
                break;

        }
    }

    public void formGetCountryList() {
        System.out.printf("| %-15s | %-15s |%n", " COUNTRY ID ", " COUNTRY NAME ");
        for (int i = 0; i < countryList.size(); i++) {
            System.out.printf("|      %-10d |       %-5s     |%n", countryList.get(i).getId(), countryList.get(i).getName());

        }
    }

    public void formCreatCountry() {
        while (true) {
            int idCategory;
            if (countryList.size() == 0) {
                idCategory = 1;
            } else {
                idCategory = countryList.get(countryList.size() - 1).getId() + 1;
            }
            System.out.println("INSERT COUNTRY NAME : ");
            String categoryName = Config.scanner().nextLine();
            if (categoryName.matches("[a-zA-Z\\d]{1,10}")){
                Country category = new Country(idCategory, categoryName);
                countryController.createCountry(category);
                System.out.println("Create success");
                countryController.showCountryList();
            }else {

                System.out.println("PLEASE ENTER COUNTRY NAME!");
            }
            System.out.println("INPUT ANY KEY TO CONTINUE - INPUT QUIT TO BACK : ");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new ViewCountry().countryMenu();
                break;
            }
        }

    }

    public void formEditCountry() {
        System.out.println("ENTER ID TO UPDATE: ");
        int idCategory = Config.getValidInteger();
        if (countryController.findCountry(idCategory) == null) {
            System.out.println("NOT EXIST");
        } else {
            Country category = countryController.findCountry(idCategory);
            System.out.println("OLD COUNTRY NAME: " + category.getName());
            System.out.println("ENTER NEW COUNTRY NAME: ");
            String newCategoryName = Config.scanner().nextLine();
            if (newCategoryName.matches("[a-zA-Z]{1,10}")) {
                newCategoryName = category.getName();
                Country newCategory = new Country(newCategoryName);
                countryController.editCountry(idCategory, newCategory);
                System.out.println("UPDATE SUCCESS");
                countryController.showCountryList();
            }else {
                System.out.println("PLEASE TRY AGAIN!");
            }


        }
        System.out.println("INPUT ANY KEY TO CONTINUE - INPUT QUIT TO BACK : ");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ViewCompany().menuCompany();
        }

    }

    public void formDeleteCountry() {
        System.out.println("ENTER ID TO DELETE: ");
        int idCategory = Config.getValidInteger();
        if (countryController.findCountry(idCategory) == null) {
            System.out.println("NOT EXIST");
        } else {
            System.out.println("1 FOR YES/ 2 FOR NO");
            int chooseDelete = Config.getValidInteger();
            switch (chooseDelete) {
                case 1:
                    countryController.deleteCountry(idCategory);
                    formGetCountryList();
                    countryController.showCountryList();
                    break;
                case 2:
                    new ViewHome();
                    break;
            }


        }
        System.out.println("INPUT ANY KEY TO CONTINUE - INPUT QUIT TO BACK : ");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ViewCountry().countryMenu();
        }
    }


}
