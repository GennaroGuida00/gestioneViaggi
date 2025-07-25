package com.example.gestioneviaggi.controller;


import com.example.gestioneviaggi.entities.Prenotazione;
import com.example.gestioneviaggi.entities.Viaggio;
import com.example.gestioneviaggi.enums.Stato;
import com.example.gestioneviaggi.payloads.NewViaggioDTO;
import com.example.gestioneviaggi.service.ViaggioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggiController {

    @Autowired
    ViaggioService viaggioService;

    @GetMapping
    public List<Viaggio> getTuttiViaggi() {
        return viaggioService.getAllViaggi();
    }

    @GetMapping("/{id}")
    public Viaggio getById(@PathVariable long id) {
        return viaggioService.findByid(id);
    }

    @PostMapping
    public Viaggio creaViaggio(@Valid @RequestBody NewViaggioDTO ViaggioDto) {
        return viaggioService.addViaggio(ViaggioDto);
    }

    @PutMapping("/{id}/stato")
    public Viaggio aggiornaStato(@PathVariable Long id, @RequestParam Stato stato) {
        return viaggioService.aggiornaStatoViaggio(id, stato);
    }

    @DeleteMapping("/{id}")
    public void eliminaViaggio(@PathVariable Long id) {
        viaggioService.elimina(id);

    }
}
