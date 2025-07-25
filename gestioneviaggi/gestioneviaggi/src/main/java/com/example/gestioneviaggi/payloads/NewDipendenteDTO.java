package com.example.gestioneviaggi.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record NewDipendenteDTO (
        @NotEmpty(message = "l'username deve essere obbligatoria!")
        String username,
        @NotEmpty(message = "il nome deve essere obbligatorio!")
        String name,
        @NotEmpty(message = "il cognome deve essere obbligatorio!")
        String surname,
        @NotEmpty(message = "l'email essere obbligatoria!")
        @Email
        String email
) {}
