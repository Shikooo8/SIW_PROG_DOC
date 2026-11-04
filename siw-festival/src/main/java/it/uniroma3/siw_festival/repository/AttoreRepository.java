package it.uniroma3.siw_festival.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw_festival.model.Attore;

/**
 * AttoreRepository
 */
public interface AttoreRepository extends CrudRepository<Attore, Long> {
    boolean existsByNomeAndCognome(String nome, String cognome);

    boolean existsByNomeAndCognomeAndIdNot(String nome, String cognome, Long id);

    List<Attore> findTop15ByCognomeStartingWithIgnoreCaseOrNomeStartingWithIgnoreCaseOrderByCognomeAscNomeAsc(String cognome, String nome);
}
