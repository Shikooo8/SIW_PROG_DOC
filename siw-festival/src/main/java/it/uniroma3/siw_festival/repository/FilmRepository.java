package it.uniroma3.siw_festival.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw_festival.model.Film;

public interface FilmRepository extends CrudRepository<Film, Long>{

    boolean existsByTitoloAndAnno(String titolo, Integer anno);


    @Query("SELECT f FROM Film f LEFT JOIN FETCH f.proiezioni p LEFT JOIN FETCH p.festival LEFT JOIN FETCH p.sala WHERE f.id = :id")
    Film findByIdWithProiezioni(@Param("id") Long id);

    boolean existsByTitoloAndAnnoAndIdNot(String titolo, Integer anno, Long id);

}
