package com.example.gestioneviaggi.payloads;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record NewPrenotazioneDTO(
        @NotNull(message = "l'id deve essere obbligatoria!")
        Long dipendenteId,
        @NotNull(message = "l'id deve essere obbligatoria!")
        Long viaggioId,
       @NotNull
        @FutureOrPresent( message = "la data da inserire non deve essere nel passato")
        LocalDate dataRichiesta,
        @NotEmpty(message = "le note devono essere obbligatorie!")
        String note
) {}
