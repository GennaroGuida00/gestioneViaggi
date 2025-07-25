package com.example.gestioneviaggi.payloads;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

public record NewViaggioDTO(
        @NotEmpty(message = "la destinazione deve essere obbligatoria!")
        String destinazione,
        @NotNull
        @FutureOrPresent( message = "la data da inserire non deve essere nel passato")
        LocalDate dataPartenza,
        @NotEmpty(message = "lo stato deve essere obbligatoria!")
        String statoViaggio) {

    }
