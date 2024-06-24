package com.paises.java.paises2902274.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paises.java.paises2902274.entities.Pais;
import com.paises.java.paises2902274.repositories.PaisRepository;


@Service
public class PaisServiceImpl implements IPaisService{

    @Autowired
    private PaisRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Pais> findAll() {
        return (List<Pais>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pais> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Pais save(Pais pais) {
        return repository.save(pais);
    }

    @Override
    public Optional<Pais> delete(Long id) {
           Optional<Pais> PaisDB = repository.findById(id);
           PaisDB.ifPresent( p -> {
            repository.delete(p);
           });
           return PaisDB;
    }

}
