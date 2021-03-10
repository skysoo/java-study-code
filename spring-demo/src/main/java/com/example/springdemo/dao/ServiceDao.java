package com.example.springdemo.dao;

import java.util.List;
import java.util.Optional;

public interface ServiceDao<T> {
    List<T> findAll();
    Optional<T> findById(String id);
    T save(T t);
    T update(T t);
    void deleteById(String id);
}
