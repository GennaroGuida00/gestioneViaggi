package com.example.gestioneviaggi.service;


import com.example.gestioneviaggi.entities.Dipendente;
import com.example.gestioneviaggi.entities.Prenotazione;
import com.example.gestioneviaggi.exceptions.NotFoundException;
import com.example.gestioneviaggi.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    PrenotazioneRepository prenotazioneRepository;

    public List<Prenotazione> getAllPrenotazioni(){
        return prenotazioneRepository.findAll();
    }

    public Prenotazione findByid(long id){
        return prenotazioneRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    public Prenotazione addPrenotazione(Prenotazione prenotazione){

        return prenotazioneRepository.save(prenotazione);
    }

    public Prenotazione prenota (Prenotazione prenotazione){
        
    }

    public void elimina(long id){

        prenotazioneRepository.deleteById(id);

    }
}
