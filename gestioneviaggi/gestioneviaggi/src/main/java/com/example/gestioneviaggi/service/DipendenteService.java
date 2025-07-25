package com.example.gestioneviaggi.service;



import com.example.gestioneviaggi.entities.Dipendente;
import com.example.gestioneviaggi.entities.Viaggio;
import com.example.gestioneviaggi.exceptions.NotFoundException;
import com.example.gestioneviaggi.payloads.NewDipendenteDTO;
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

    public List<Dipendente> findAll(){
        return dipendenteRepository.findAll();
    }

    public Dipendente addDipendente(NewDipendenteDTO dipendenteDto){
        Dipendente dipendente=new Dipendente();
        dipendente.setUsername(dipendenteDto.username());
        dipendente.setName(dipendenteDto.name());
        dipendente.setSurname(dipendenteDto.surname());
        dipendente.setMail(dipendenteDto.email());
        return dipendenteRepository.save(dipendente);
    }
    public void elimina(long id){

        dipendenteRepository.deleteById(id);

    }
}
