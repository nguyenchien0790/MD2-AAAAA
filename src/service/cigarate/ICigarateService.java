package service.cigarate;

import model.Cigarate;
import service.IGenericService;

import java.util.List;

public interface ICigarateService extends IGenericService<Cigarate> {
    List<Cigarate> sortCigarateList();
}
