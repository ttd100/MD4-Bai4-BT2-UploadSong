package rikkei.academy.service;

import java.util.List;

public interface IGenericService<T> {
    List<T> findAll();

    void save(T t);

    T findById(int id);

    void update(int id, T t);

    void remove(int id);
}