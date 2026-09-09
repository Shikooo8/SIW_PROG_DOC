package it.uniroma3.siw_festival.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw_festival.model.Recensione;

public interface RecensioneRepository extends CrudRepository<Recensione, Long> {

    Optional<Recensione> findByFilmIdAndUtenteUsername(Long filmId, String username);

    boolean existsByFilmTitoloAndUtenteUsername(String filmTitolo, String username);
}