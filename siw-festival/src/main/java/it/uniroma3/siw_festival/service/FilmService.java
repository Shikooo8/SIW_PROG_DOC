package it.uniroma3.siw_festival.service;


import java.util.List;

import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.repository.FilmRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    private FilmRepository filmRepository;

    
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;

    }

    public Film findById(Long id){
        return filmRepository.findById(id).get();
    }

    public List<Film> findAll () {
        return (List<Film>) filmRepository.findAll();
    }

    
    public Film save(Film film) throws DuplicateFilmException {
        if(filmRepository.existsByTitoloAndAnno(film.getTitolo(), film.getAnno())) {
            throw new DuplicateFilmException(film.getTitolo(), film.getAnno());
            
        }
    return filmRepository.save(film);
    }
     
}







