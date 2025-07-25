package com.example.gestioneviaggi.payloads;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record NewViaggioDTO(
        @NotEmpty(message = "la destinazione deve essere obbligatoria!")
        @Size(max = 20, message = "Il nome della destinazione deve essere di lunghezza compresa tra 2 e 20")
        String destinazione,
        @NotEmpty(message = "la data è obbligatoria!")
        @FutureOrPresent( message = "la data da inserire non deve essere nel passato")
        LocalDate dataPartenza,
        @NotEmpty(message = "lo stato deve essere obbligatoria!")
        @Size(max = 20, message = "Il nome della destinazione deve essere di lunghezza massima 12")
        String statoViaggio) {

    }
