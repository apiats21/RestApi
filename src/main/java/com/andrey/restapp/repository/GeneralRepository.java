package com.andrey.restapp.repository;
import java.util.List;

public interface GeneralRepository<T, ID> {
    T getById(ID id);
    T save(T t);
    List<T> getAll();
    T update(T t);
    void deleteById(ID id);
}
