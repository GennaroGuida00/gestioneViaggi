package com.example.gestioneviaggi.repository;


import com.example.gestioneviaggi.entities.Dipendente;
import com.example.gestioneviaggi.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
    Optional<Viaggio> findById(long id);


}
