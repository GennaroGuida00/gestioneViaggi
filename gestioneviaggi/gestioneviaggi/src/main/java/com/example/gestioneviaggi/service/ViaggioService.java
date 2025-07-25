package com.example.gestioneviaggi.service;


import com.example.gestioneviaggi.entities.Viaggio;
import com.example.gestioneviaggi.exceptions.NotFoundException;
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

    public Viaggio findByid(long id){
        return viaggioRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    public Viaggio addViaggio(Viaggio viaggio){
        return viaggioRepository.save(viaggio);
    }


    public void elimina(long id){

        viaggioRepository.deleteById(id);

    }
}
