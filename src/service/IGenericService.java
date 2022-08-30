package service;

import java.util.List;

public interface IGenericService<T> {

    List<T> findAll();

    void save(T t);

    void remove(int id);

    T findById(int id);

    void updateData();

    int getLastId();
}
