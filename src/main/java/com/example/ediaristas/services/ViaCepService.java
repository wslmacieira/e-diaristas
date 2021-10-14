package com.example.ediaristas.services;

import com.example.ediaristas.dtos.ViaCepResponse;
import com.example.ediaristas.exceptions.CepInvalidoException;
import com.example.ediaristas.exceptions.CepNaoEncontradoException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {
    
    public ViaCepResponse buscarEnderecoPorCep(String cep) {
        var url = "https://viacep.com.br/ws/" + cep + "/json/";

        var clienteHttp = new RestTemplate();
        ResponseEntity<ViaCepResponse> response;

        try {
            response = clienteHttp.getForEntity(url, ViaCepResponse.class);
        } catch (HttpClientErrorException.BadRequest e) {
            throw new CepInvalidoException("CEP invalido!");
        }

        if (response.getBody().getCep() == null) {
            throw new CepNaoEncontradoException("CEP nã encontrado");
        }
        
        return response.getBody();
    }
}
