package com.paises.java.paises2902274.services;

import java.util.List;
import java.util.Optional;

import com.paises.java.paises2902274.entities.Pais;


public interface IPaisService {

    //CRUD
    List<Pais> findAll();

    Optional<Pais> findById(Long id);

    Pais save(Pais pais);

    Optional<Pais> delete(Long id);
}
