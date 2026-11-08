package it.uniroma3.siw_festival.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw_festival.model.Proiezione;
import it.uniroma3.siw_festival.model.Sala;

public interface ProiezioneRepository extends CrudRepository<Proiezione, Long> {
    List<Proiezione> findBySalaIdAndData(Long salaId, LocalDate data);

    List<Proiezione> findByFestivalId(Long festivalId);

    // Nel ProiezioneRepository.java
    Proiezione findBySalaAndDataAndOra(Sala sala, LocalDate data, LocalTime ora);

    List<Proiezione> findBySalaAndData(Sala sala, LocalDate data);

    boolean existsBySalaId(Long salaId);

    
    @Query("SELECT p FROM Proiezione p " +"JOIN FETCH p.film JOIN FETCH p.sala " +"WHERE p.festival.id = :festivalId AND p.data = :data " + "ORDER BY p.ora")
    List<Proiezione> findByFestivalIdAndData(@Param("festivalId") Long festivalId, @Param("data") LocalDate data); //TODO controlla questi ""
}