package com.example.gestioneviaggi.repository;


import com.example.gestioneviaggi.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.ScopedValue;
import java.util.UUID;

@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {


}
