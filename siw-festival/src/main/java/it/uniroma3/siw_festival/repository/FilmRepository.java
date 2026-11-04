package it.uniroma3.siw_festival.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw_festival.model.Film;

public interface FilmRepository extends CrudRepository<Film, Long> {

    boolean existsByTitoloAndAnno(String titolo, Integer anno);

    @Query("SELECT f FROM Film f LEFT JOIN FETCH f.proiezioni p LEFT JOIN FETCH p.festival LEFT JOIN FETCH p.sala WHERE f.id = :id")
    Film findByIdWithProiezioni(@Param("id") Long id);

    @Query("SELECT f FROM Film f LEFT JOIN FETCH f.interpretazioni i LEFT JOIN FETCH i.attore WHERE f.id = :id")
    Film findByIdWithCast(@Param("id") Long id); // TODO controllare se ha senso e soprattutto inserirla nel controlloer
                                                 // per fare un EAGER

    boolean existsByTitoloAndAnnoAndIdNot(String titolo, Integer anno, Long id);

    List<Film> findTop15ByTitoloStartingWithIgnoreCaseOrderByTitoloAsc(String prefisso);

    // film collegati a un festival (serve per la pagina di modifica del festival)
    List<Film> findByFestivalsId(Long festivalId);

    boolean existsByIdAndFestivalsId(Long filmId, Long festivalId);

}
