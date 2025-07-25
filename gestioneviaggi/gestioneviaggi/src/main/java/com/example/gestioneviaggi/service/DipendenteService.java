package com.example.gestioneviaggi.service;



import com.example.gestioneviaggi.entities.Dipendente;
import com.example.gestioneviaggi.entities.Viaggio;
import com.example.gestioneviaggi.exceptions.NotFoundException;
import com.example.gestioneviaggi.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendenteService {

    @Autowired
    DipendenteRepository dipendenteRepository;


    public Dipendente findByid(long id){
        return dipendenteRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    public Dipendente addDipendente(Dipendente dipendente){
        return dipendenteRepository.save(dipendente);
    }
    public void elimina(long id){

        dipendenteRepository.deleteById(id);

    }
}
