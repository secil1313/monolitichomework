package com.homework1.utility;

import java.util.List;
import java.util.Optional;

public interface IService <T,ID>{
    T save(T t);
    List<T> findAll();
    Optional<T> findById(ID id);
}
