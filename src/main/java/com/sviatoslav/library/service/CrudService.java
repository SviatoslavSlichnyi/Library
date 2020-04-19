package com.sviatoslav.library.service;

import java.util.List;

public interface CrudService<T, I> {

    T save(T t);

    T findById(I id);

    T update(T t);

    void deleteById(I id);

    void deleteAll();

    List<T> findAll();

}
