package com.example.demo_spring_jbdc.controller;

import com.example.demo_spring_jbdc.model.entity.Acquisto;
import com.example.demo_spring_jbdc.repository.AcquistiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acquisti")
public class AcquistiController {

    private final AcquistiRepository repository;

    @Autowired
    public AcquistiController(AcquistiRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void salvaAcquisto(@RequestBody Acquisto acquisto) {
        repository.salvaAcquisto(acquisto);
    }

    @GetMapping
    public List<Acquisto> recuperaAcquisti(){
        return repository.recuperaAcquisti();
    }
    
}
