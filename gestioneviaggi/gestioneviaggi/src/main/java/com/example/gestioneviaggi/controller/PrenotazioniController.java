package com.example.gestioneviaggi.controller;


import com.example.gestioneviaggi.entities.Dipendente;
import com.example.gestioneviaggi.entities.Prenotazione;
import com.example.gestioneviaggi.payloads.NewPrenotazioneDTO;
import com.example.gestioneviaggi.service.PrenotazioneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

    @Autowired
    PrenotazioneService prenotazioneService;

    @GetMapping
    public List<Prenotazione> getTuttePrenotazioni() {
        return prenotazioneService.getAllPrenotazioni();
    }

    @PostMapping
    public Prenotazione creaPrenotazione(@Valid @RequestBody NewPrenotazioneDTO prenotazioneDto) {
        return prenotazioneService.prenota(prenotazioneDto);
    }

    @DeleteMapping("/{id}")
    public void eliminaPrenotazione(@PathVariable Long id) {
        prenotazioneService.elimina(id);
    }

    @GetMapping("/{id}")
    public Prenotazione getById(@PathVariable long id) {
        return prenotazioneService.findByid(id);
    }
}
