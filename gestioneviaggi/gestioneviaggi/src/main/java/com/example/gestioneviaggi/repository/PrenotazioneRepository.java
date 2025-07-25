package com.example.gestioneviaggi.repository;

import com.example.gestioneviaggi.entities.Dipendente;
import com.example.gestioneviaggi.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    @Query("SELECT COUNT(p) from Prenotazione p WHERE p.dipendente=:dipendente AND p.dataRichiesta=:dataRichiesta")
    int numeroPrenotazioniDipendentePerData(@Param("dipendente")Dipendente dipendente,@Param("dataRichiesta") LocalDate dataRichiesta );
}
