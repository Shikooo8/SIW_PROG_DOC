package it.uniroma3.siw_festival.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw_festival.exception.DuplicateFestivalException;
import it.uniroma3.siw_festival.exception.DuplicateFilmException;
import it.uniroma3.siw_festival.exception.DuplicateRecensioneException;
import it.uniroma3.siw_festival.model.Festival;
import it.uniroma3.siw_festival.model.Recensione;
import it.uniroma3.siw_festival.repository.FestivalRepository;
import it.uniroma3.siw_festival.repository.RecensioneRepository;

public class RecensioneService {

    private RecensioneRepository recensioneRepository;

    public RecensioneService(RecensioneRepository recensioneRepository) {
        this.recensioneRepository = recensioneRepository;

    }

    public Recensione findById(Long id){
        return recensioneRepository.findById(id).get();
    }

    public List<Recensione> findAll () {
        return (List<Recensione>) recensioneRepository.findAll();
    }

    
        public Long count() {
        return this.recensioneRepository.count();
    }

    @Transactional
      public Recensione save(Recensione recensione) throws DuplicateRecensioneException {

        if(recensioneRepository.existsByFilmTitoloAndUtenteUsername(recensione.getFilm().getTitolo(), recensione.getUtente().getUsername())) {
            throw new DuplicateRecensioneException(recensione.getFilm().getTitolo(), recensione.getUtente().getUsername());
            
        }
        //logger.info("è stato creato il festival: id={}", festival.getId()); //TODO da controllare
        return recensioneRepository.save(recensione);
    }

}
