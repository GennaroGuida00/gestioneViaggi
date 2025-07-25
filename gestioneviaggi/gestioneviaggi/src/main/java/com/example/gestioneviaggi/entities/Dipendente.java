package com.example.gestioneviaggi.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table (name = "dipendenti")
public class Dipendente {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String username;
    private String name;
    private String surname;
    private String mail;

    public Dipendente(String username, String name, String surname, String mail) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
    }

    public Dipendente() {
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
