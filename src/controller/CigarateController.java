package controller;

import model.Cigarate;
import service.cigarate.CigarateServiceIMPL;
import service.cigarate.ICigarateService;

import java.util.List;

public class CigarateController {
    ICigarateService cigarateService = new CigarateServiceIMPL();
    public List<Cigarate> showListCigarate(){
        return cigarateService.findAll();
    }
    public void createCigarate(Cigarate cigarate){
        cigarateService.save(cigarate);
    }
    public Cigarate detailCigarate(int id){
        return cigarateService.findById(id);
    }
    public void editCar(int id, Cigarate newCigarate){
        Cigarate cigarate = cigarateService.findById(id);
        cigarate.setCompany(newCigarate.getCompany());
        cigarate.setNameCigarate(newCigarate.getNameCigarate());
        cigarate.setCountry(newCigarate.getCountry());
        cigarate.setPrice(newCigarate.getPrice());
    }
    public void deleteById(int id){
        cigarateService.remove(id);
    }
    public List<Cigarate> sortByNamCigarate(){
        return cigarateService.sortCigarateList();
    }

}
