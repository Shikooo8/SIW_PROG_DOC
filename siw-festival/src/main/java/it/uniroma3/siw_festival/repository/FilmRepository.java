package it.uniroma3.siw_festival.repository;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw_festival.model.Film;

public interface FilmRepository extends CrudRepository<Film, Long>{

}
