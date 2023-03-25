package com.homework1.utility;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class ServiceManager<T,ID> implements IService<T,ID> {

    private final JpaRepository<T,ID> repository;
    public ServiceManager(JpaRepository<T,ID> repository){

        this.repository=repository;
    }
    @Override
    public T save(T t) {

        return repository.save(t);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }
}
