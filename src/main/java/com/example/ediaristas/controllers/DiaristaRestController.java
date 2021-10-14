package com.example.ediaristas.controllers;

import java.util.List;

import com.example.ediaristas.models.Diarista;
import com.example.ediaristas.repositories.DiaristaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diaristas-cidade")
public class DiaristaRestController {
    
    @Autowired
    private DiaristaRepository repository;

    @GetMapping
    public List<Diarista> buscarDiaristaPorCep() {
        return repository.findAll();
    }
}
