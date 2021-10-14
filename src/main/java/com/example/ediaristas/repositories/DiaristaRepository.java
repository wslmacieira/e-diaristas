package com.example.ediaristas.repositories;

import java.util.List;

import com.example.ediaristas.models.Diarista;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaristaRepository extends JpaRepository<Diarista, Long>{
    
    List<Diarista> findByCodigoIbge(String codigoIbge);
}
