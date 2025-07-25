package com.example.gestioneviaggi.controller;

import com.example.gestioneviaggi.entities.Dipendente;
import com.example.gestioneviaggi.exceptions.NotFoundException;
import com.example.gestioneviaggi.payloads.NewDipendenteDTO;
import com.example.gestioneviaggi.service.DipendenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {
    @Autowired
    private  DipendenteService dipendenteService;


    @GetMapping
    public List<Dipendente> getTuttiDipendenti() {
        return dipendenteService.findAll();
    }

    @PostMapping
    public Dipendente creaDipendente(@Valid @RequestBody NewDipendenteDTO dipendenteDto) {
        return dipendenteService.addDipendente(dipendenteDto);
    }

    @DeleteMapping("/{id}")
    public void eliminaDipendente(@PathVariable Long id) {

        dipendenteService.elimina(id);
    }

    @GetMapping("/{id}")
    public Dipendente getById(@PathVariable long id) {
        return dipendenteService.findByid(id);
    }
    
}

