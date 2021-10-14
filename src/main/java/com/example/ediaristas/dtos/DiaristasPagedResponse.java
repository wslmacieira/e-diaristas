package com.example.ediaristas.dtos;

import java.util.List;

import com.example.ediaristas.models.Diarista;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaristasPagedResponse {
    
    private List<Diarista> diaristas;

    @JsonProperty("quantidade_diaristas")
    private Long quantidadeDiaristas;
}
