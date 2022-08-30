package service.cigarate;

import config.Config;
import model.Cigarate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CigarateServiceIMPL implements ICigarateService{
    static String PATH_CIGARATE = "src/database/cigarate.txt";
    static Config<List<Cigarate>> config = new Config<>();
    public static List<Cigarate> cigarateList = config.read(PATH_CIGARATE);
    static {
        if (cigarateList == null) {
            cigarateList = new ArrayList<>();
        }
    }

    @Override
    public List<Cigarate> findAll() {
        return cigarateList;
    }

    @Override
    public void save(Cigarate cigarate) {
        cigarateList.add(cigarate);
        updateData();
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < cigarateList.size(); i++) {
            if (id == (cigarateList.get(i).getId())) {
                cigarateList.remove(i);
            }
        }
        updateData();
    }



    @Override
    public Cigarate findById(int id) {
        for (int i = 0; i < cigarateList.size(); i++) {
            if (cigarateList.get(i).getId() == id) {
                return cigarateList.get(i);
            }
        }
        return null;
    }


    @Override
    public void updateData() {
        config.write(PATH_CIGARATE,cigarateList);

    }

    @Override
    public int getLastId() {
        return 0;
    }

    @Override
    public List<Cigarate> sortCigarateList() {
        List<Cigarate> listSort = new ArrayList<>();
        for (int i = 0; i < cigarateList.size(); i++) {
            listSort.add(cigarateList.get(i));
        }
        Collections.sort(listSort);
        updateData();
        return listSort;
    }

}
