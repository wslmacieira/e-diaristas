package com.example.ediaristas.controllers;

import java.util.List;

import com.example.ediaristas.dtos.DiaristasPagedResponse;
import com.example.ediaristas.dtos.ViaCepResponse;
import com.example.ediaristas.models.Diarista;
import com.example.ediaristas.repositories.DiaristaRepository;
import com.example.ediaristas.services.ViaCepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diaristas-cidade")
public class DiaristaRestController {

    @Autowired
    private DiaristaRepository repository;

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping
    public DiaristasPagedResponse buscarDiaristaPorCep(@RequestParam String cep) {
        var endereco = viaCepService.buscarEnderecoPorCep(cep);
        var codigoIbge = endereco.getIbge();

        var pageable = PageRequest.of(0, 6);
        var diaristas = repository.findByCodigoIbge(codigoIbge, pageable);

        var quantidadeDiaristas = diaristas.getTotalElements() > 6 ? diaristas.getTotalElements() - 6 : 0;

        return new DiaristasPagedResponse(diaristas.getContent(), quantidadeDiaristas);
    }
}
