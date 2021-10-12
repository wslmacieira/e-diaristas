package com.example.ediaristas.reposiries;

import com.example.ediaristas.models.Diarista;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaristaRepository extends JpaRepository<Diarista, Long>{
    
}
