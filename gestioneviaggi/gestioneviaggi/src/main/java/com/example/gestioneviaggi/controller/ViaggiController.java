package com.example.gestioneviaggi.controller;


import com.example.gestioneviaggi.service.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viaggi")
public class ViaggiController {

    @Autowired
    ViaggioService viaggioService;

    public Response


}
