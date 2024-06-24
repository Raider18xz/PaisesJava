package com.paises.java.paises2902274.controller;

import org.springframework.web.bind.annotation.RestController;

import com.paises.java.paises2902274.entities.Pais;
import com.paises.java.paises2902274.services.PaisServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/api/pais")
public class PaisController {
    @Autowired
    private PaisServiceImpl service;

    @GetMapping
    public List<Pais> mostrarPais(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Pais mostrarPaisPorId(@PathVariable Long id){
        Optional<Pais> optPais = service.findById(id);
        return optPais.get();
    }

    @PostMapping
    public Pais crearPais(@RequestBody Pais paisGrabar) { 
        Pais paisNew = service.save(paisGrabar);
        return paisNew;
        
    }
    @PutMapping("/{id}")
    public Pais actualizarPais(@PathVariable Long id, @RequestBody Pais paisU) { 
        Pais p = service.findById(id).get();
        p.setCapital(paisU.getCapital());
        p.setNombre(paisU.getNombre());
        return service.save(p);
    }
    @DeleteMapping("/{id}")
    public Pais eliminarPais(@PathVariable Long id) { 
        Optional<Pais> optDel = service.delete(id);
        return optDel.get();
    }
}
