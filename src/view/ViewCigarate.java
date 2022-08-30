package view;

import config.Config;
import controller.CigarateController;
import model.Cigarate;

import java.util.List;

public class ViewCigarate {
    CigarateController cigarateController = new CigarateController();
    List<Cigarate> cigarateList = cigarateController.showListCigarate();

    public void menuCigarate(){
        System.out.println("*****CIGARATE MANAGER******");
        System.out.println("1. Show cigarate list    ");
        System.out.println("2. Create cigarate     ");
        System.out.println("3. Find detail cigarate  ");
        System.out.println("4. Update cigarate       ");
        System.out.println("5. Delete cigarate       ");
        System.out.println("6. Back       ");
        int choice = Config.getValidInteger();
        switch (choice) {
            case 1:
                formShowCigarateList();
                break;
            case 2:
                formCreateCigarate();
                break;
            case 3:
                formFindDetailCigarate();
                break;
            case 4:
                formEditCigarate();
                break;
            case 5:
                formDeleteCigarate();
                break;
            case 6:
                new ViewHome();
                break;
            default:
                System.out.println("INVALID CHOICE");
                break;
        }




    }

    private void formShowCigarateList() {
        System.out.printf("| %-10s | %-15s | %-15s | %-15s | %-15s | %-15s | %n", "Car id", "Name", "Country", "Price", "Company","Amount");

        for (int i = 0; i < cigarateList.size(); i++) {
            int j = i + 1;
            System.out.printf("| %-10d | %-15s | %-15s | %-15s | %-15s | %-15s |%n", j,cigarateList.get(i).getNameCigarate(), cigarateList.get(i).getCountry(), cigarateList.get(i).getPrice(), cigarateList.get(i).getCompany(), cigarateList.get(i).getAmount());
        }
    }

    private void formCreateCigarate() {
        System.out.println("********** CREAT CIGARATE ***********");
        while (true) {
            int idCigarate;
            if (cigarateList.size() == 0) {
                idCigarate = 1;
            } else {
                idCigarate = cigarateList.get(cigarateList.size() - 1).getId() + 1;
            }

            System.out.println("ENTER CIGARATE'S NAME: ");
            String name = Config.scanner().nextLine();
//            System.out.println("ENTER CIGARATE'S COUNTRY: ");
//            String country = Config.scanner().nextLine();
            System.out.println("ENTER CIGARATE'S PRICE($): ");
            int price = Config.getValidInteger();
//            System.out.println("ENTER CIGARATE'S COMPANY: ");
//            String cigarateCompany = Config.scanner().nextLine();
            System.out.println("ENTER CIGARATE'S AMOUNT: ");
            int amount = Config.getValidInteger();
            Cigarate cigarate = new Cigarate(idCigarate,name,country,price,cigarateCompany,amount);
            cigarateController.createCigarate(cigarate);
            System.out.println("Create success!");
            cigarateController.showListCigarate();
            System.out.println("INPUT ANY KEY TO CONTINUE - INPUT QUIT TO BACK : ");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new ViewCigarate().menuCigarate();
                break;
            }
        }
        
    }

    private void formFindDetailCigarate() {
        System.out.println("ENTER CIGARATE ID: ");
        int idCigarate = Config.getValidInteger();
        if (cigarateController.detailCigarate(idCigarate) == null) {
            System.out.println("NOT EXIST");
        } else {
            Cigarate cigarate = cigarateController.detailCigarate(idCigarate);
            System.out.println("YOUR CIGARATE : "+cigarate);
        }

        
    }

    private void formEditCigarate() {
        System.out.println("ENTER CIGARATE'S ID TO UPDATE: ");
        int idCigarate = Config.getValidInteger();
        if (cigarateController.detailCigarate(idCigarate) == null) {
            System.out.println("NOT EXIST");
        } else {
            Cigarate cigarate = cigarateController.detailCigarate(idCigarate);
            System.out.println("OLD CIGARATE COMPANY NAME: " + cigarate.getCompany());
            System.out.println("OLD NAME : " + cigarate.getNameCigarate());
            System.out.println("OLD COUNTRY : " + cigarate.getCountry());
            System.out.println("OLD PRICE: " + cigarate.getPrice());
            System.out.println("ENTER NEW COMPANY NAME: ");
            String newCompanyName = Config.scanner().nextLine();
            if (newCompanyName.trim().equals("")) {
                newCompanyName = cigarate.getCompany();
            }
            System.out.println("ENTER NEW CIGARATE NAME: ");
            String newCigarateName = Config.scanner().nextLine();
            if (newCigarateName.trim().equals("")) {
                newCigarateName = cigarate.getNameCigarate();
            }
            System.out.println("ENTER NEW CIGARATE COUNTRY: ");
            String newCountry = Config.scanner().nextLine();
            if (newCountry.trim().equals("")) {
                newCountry = cigarate.getCountry();
            }
            System.out.println("ENTER NEW PRICE: ");
            String newPrice = Config.scanner().nextLine();
            if (newPrice.trim().equals("")) {
                newPrice = String.valueOf(cigarate.getPrice());
            }
            Cigarate newCigarate = new Cigarate(newCompanyName, newCigarateName, newCountry, newPrice);
            cigarateController.editCar(idCigarate, newCigarate);
            System.out.println("Update success!!");
            cigarateController.showListCigarate();

        }
        System.out.println("INPUT ANY KEY TO CONTINUE - INPUT QUIT TO BACK : ");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ViewCigarate().menuCigarate();
        }
        
    }

    private void formDeleteCigarate() {
        System.out.println("ENTER CIGARATE'S ID TO DELETE: ");
        int idCigarate = Config.getValidInteger();
        if (cigarateController.detailCigarate(idCigarate) == null) {
            System.out.println("NOT EXIST");
        } else {
            System.out.println("1 FOR YES/ 2 FOR NO");
            int chooseDelete = Config.getValidInteger();
            switch (chooseDelete) {
                case 1:
                    cigarateController.deleteById(idCigarate);
                    formShowCigarateList();
                    cigarateController.showListCigarate();
                    break;
                case 2:
                    new ViewHome();
                    break;
            }
        }
        System.out.println("INPUT ANY KEY TO CONTINUE OR INPUT < QUIT > TO BACK : ");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ViewCigarate().menuCigarate();
        }
        
    }

}
