package it.uniroma3.siw_festival.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw_festival.model.Proiezione;

public interface ProiezioneRepository extends CrudRepository<Proiezione, Long> {
    List<Proiezione> findBySalaIdAndData(Long salaId, LocalDate data);
    List<Proiezione> findByFestivalId(Long festivalId);
}