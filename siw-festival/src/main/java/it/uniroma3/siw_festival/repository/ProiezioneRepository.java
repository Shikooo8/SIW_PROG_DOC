package it.uniroma3.siw_festival.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw_festival.model.Proiezione;
import it.uniroma3.siw_festival.model.Sala;

public interface ProiezioneRepository extends CrudRepository<Proiezione, Long> {
    List<Proiezione> findBySalaIdAndData(Long salaId, LocalDate data);

    List<Proiezione> findByFestivalId(Long festivalId);

    // Nel ProiezioneRepository.java
    Proiezione findBySalaAndDataAndOra(Sala sala, LocalDate data, LocalTime ora);

    List<Proiezione> findBySalaAndData(Sala sala, LocalDate data);
}