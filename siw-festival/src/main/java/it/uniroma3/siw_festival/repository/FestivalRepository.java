package it.uniroma3.siw_festival.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw_festival.model.Festival;


public interface FestivalRepository extends CrudRepository<Festival, Long>{

    boolean existsByNomeAndAnno(String nome, Integer anno);

    @Query("SELECT f FROM Festival f LEFT JOIN FETCH f.proiezioni p LEFT JOIN FETCH p.film LEFT JOIN FETCH p.sala WHERE f.id = :id")
    Festival findByIdWithProiezioni(@Param("id") Long id);
// Controlla i duplicati escludendo l'ID corrente (utile in fase di update)
boolean existsByNomeAndAnnoAndIdNot(String nome, Integer anno, Long id);
}
