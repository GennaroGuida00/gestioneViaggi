package com.example.gestioneviaggi.service;


import com.example.gestioneviaggi.entities.Dipendente;
import com.example.gestioneviaggi.entities.Prenotazione;
import com.example.gestioneviaggi.entities.Viaggio;
import com.example.gestioneviaggi.exceptions.NotFoundException;
import com.example.gestioneviaggi.payloads.NewPrenotazioneDTO;
import com.example.gestioneviaggi.repository.DipendenteRepository;
import com.example.gestioneviaggi.repository.PrenotazioneRepository;
import com.example.gestioneviaggi.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    PrenotazioneRepository prenotazioneRepository;

    @Autowired
    DipendenteRepository dipendenteRepository;

    @Autowired
    ViaggioRepository viaggioRepository;


    public List<Prenotazione> getAllPrenotazioni(){
        return prenotazioneRepository.findAll();
    }

    public Prenotazione findByid(long id){
        return prenotazioneRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    public Prenotazione prenota (NewPrenotazioneDTO prenotazioneDto){

        Dipendente dipendente=dipendenteRepository.findById(prenotazioneDto.dipendenteId()).orElseThrow(()->new NotFoundException(prenotazioneDto.dipendenteId()));
        Viaggio viaggio=viaggioRepository.findById(prenotazioneDto.viaggioId()).orElseThrow(()->new NotFoundException(prenotazioneDto.viaggioId()));
        LocalDate dataRichiesta=prenotazioneDto.dataRichiesta();

        boolean esistePrenotazione = prenotazioneRepository.numeroPrenotazioniDipendentePerData(dipendente, dataRichiesta) > 0;
        if (esistePrenotazione){
            throw new IllegalArgumentException("Il dipendente ha gia un prenotazione per la data indicata");
        }
        Prenotazione prenotazione=new Prenotazione();
        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        prenotazione.setDataRichiesta(dataRichiesta);
        prenotazione.setNoteViaggio(prenotazioneDto.note());
        return prenotazioneRepository.save(prenotazione);


    }

    public void elimina(long id){

        prenotazioneRepository.deleteById(id);

    }
}
