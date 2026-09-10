package it.uniroma3.siw_festival.service;

     
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Optional;

import it.uniroma3.siw_festival.exception.DuplicateFilmException;
import it.uniroma3.siw_festival.exception.FilmNotFoundException;
import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.repository.FilmRepository;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class FilmService {
    
    private FilmRepository filmRepository;
    
  //  private static final Logger logger = LoggerFactory.getLogger(FilmService.class);
    
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;

    }

    //PREVEDE ERRORE 404
    @Transactional 
    public Film findById(Long id){
        Optional<Film> optionalFilm = filmRepository.findById(id);
        if(optionalFilm.isPresent()){
            return optionalFilm.get();
        } else{
            throw new FilmNotFoundException(id);
        }
    }

    @org.springframework.transaction.annotation.Transactional (readOnly = true)
    public Film findByIdWithProiezioni(Long id) {
    return filmRepository.findByIdWithProiezioni(id);
}

    public List<Film> findAll () {
        return (List<Film>) filmRepository.findAll();
    }

    @Transactional 
 public Film save(Film film) throws DuplicateFilmException {
    if (film.getId() == null) {
        // Inserimento nuovo film
        if (filmRepository.existsByTitoloAndAnno(film.getTitolo(), film.getAnno())) {
            throw new DuplicateFilmException(film.getTitolo(), film.getAnno());
        }
    } else {
        // Modifica film esistente: escludi l'ID corrente dalla ricerca
        if (filmRepository.existsByTitoloAndAnnoAndIdNot(film.getTitolo(), film.getAnno(), film.getId())) {
            throw new DuplicateFilmException(film.getTitolo(), film.getAnno());
        }
    }
    return filmRepository.save(film);
}

    public Long count() {
        return this.filmRepository.count();
    }




  

}







