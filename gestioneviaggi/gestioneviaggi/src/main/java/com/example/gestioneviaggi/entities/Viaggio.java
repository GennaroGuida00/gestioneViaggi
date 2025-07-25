package com.example.gestioneviaggi.entities;

import com.example.gestioneviaggi.enums.Stato;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "viaggi")
public class Viaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String destinazione;
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private Stato statoViaggio;

    public Viaggio(String destinazione, LocalDate data, Stato statoViaggio) {
        this.destinazione = destinazione;
        this.data = data;
        this.statoViaggio = statoViaggio;
    }

    public Viaggio() {
    }

    public long getId() {
        return id;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Stato getStatoViaggio() {
        return statoViaggio;
    }

    public void setStatoViaggio(Stato statoViaggio) {
        this.statoViaggio = statoViaggio;
    }

    @Override
    public String toString() {
        return "Viaggio{" +
                "id=" + id +
                ", destinazione='" + destinazione + '\'' +
                ", data=" + data +
                ", statoViaggio=" + statoViaggio +
                '}';
    }
}
