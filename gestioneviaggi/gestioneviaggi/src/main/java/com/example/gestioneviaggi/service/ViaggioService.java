package com.example.gestioneviaggi.service;


import com.example.gestioneviaggi.entities.Prenotazione;
import com.example.gestioneviaggi.entities.Viaggio;
import com.example.gestioneviaggi.enums.Stato;
import com.example.gestioneviaggi.exceptions.NotFoundException;
import com.example.gestioneviaggi.payloads.NewViaggioDTO;
import com.example.gestioneviaggi.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViaggioService {

    @Autowired
    ViaggioRepository viaggioRepository;


    public List<Viaggio> getAllViaggi(){
        return viaggioRepository.findAll();
    }

    public Viaggio addViaggio(NewViaggioDTO viaggioDTO){
        Viaggio viaggio =new Viaggio();
        viaggio.setDestinazione(viaggioDTO.destinazione());
        viaggio.setData(viaggioDTO.dataPartenza());
        viaggio.setStatoViaggio(Stato.IN_PROGRAMMA);
        return viaggioRepository.save(viaggio);
    }

    public Viaggio findByid(long id){
        return viaggioRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    public Viaggio aggiornaStatoViaggio(long id , Stato nuovoStato){
        Viaggio viaggio=viaggioRepository.findById(id).orElseThrow(()->new NotFoundException(id));
        viaggio.setStatoViaggio(nuovoStato);
        return viaggioRepository.save(viaggio);
    }


    public void elimina(long id){

        viaggioRepository.deleteById(id);

    }
}
