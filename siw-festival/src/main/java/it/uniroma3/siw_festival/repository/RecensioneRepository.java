package it.uniroma3.siw_festival.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw_festival.model.Recensione;

public interface RecensioneRepository extends CrudRepository<Recensione, Long> {
    List<Recensione> findByFilmId(Long filmId);


    @Query("SELECT r FROM Recensione r WHERE r.film.id = :filmId AND r.utente.username = :username")
Optional<Recensione> findByFilmIdAndUsername(@Param("filmId") Long filmId, @Param("username") String username);

    boolean existsByFilmTitoloAndFilmAnnoAndUtenteUsername(String filmTitolo, Integer filmAnno, String username);
}