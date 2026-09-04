package it.uniroma3.siw_festival.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw_festival.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long> {
    Optional<Utente> findByUsername(String username);
}
