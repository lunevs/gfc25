package ru.ichtus.gfc.backend.service;


import java.util.List;

public interface DefaultService<T> {

    List<T> findAll();
    T findById(Integer id);
    T save(T item);
    T update(T item);
    void deleteById(Integer id);

}
