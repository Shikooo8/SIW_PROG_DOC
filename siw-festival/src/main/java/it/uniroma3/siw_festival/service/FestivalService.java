package it.uniroma3.siw_festival.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.uniroma3.siw_festival.exception.DuplicateFestivalException;
import it.uniroma3.siw_festival.exception.DuplicateFilmException;
import it.uniroma3.siw_festival.model.Festival;
import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.repository.FestivalRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service 
public class FestivalService {

     private FestivalRepository festivalRepository;

    
    public FestivalService(FestivalRepository festivalRepository) {
        this.festivalRepository = festivalRepository;

    }

    @org.springframework.transaction.annotation.Transactional (readOnly = true)
    public Festival findByIdWithProiezioni(Long id) {
    return festivalRepository.findByIdWithProiezioni(id);
}

    public Festival findById(Long id){
        return festivalRepository.findById(id).get();
    }

    public List<Festival> findAll () {
        return (List<Festival>) festivalRepository.findAll();
    }

    
        public Long count() {
        return this.festivalRepository.count();
    }

    @Transactional
public Festival save(Festival festival) throws DuplicateFestivalException {
    if (festival.getId() == null) {
        // È un inserimento nuovo: controlla tutto
        if (festivalRepository.existsByNomeAndAnno(festival.getNome(), festival.getAnno())) {
            throw new DuplicateFestivalException(festival.getNome(), festival.getAnno());
        }
    } else {
        // È un aggiornamento: ignora l'ID del festival stesso
        if (festivalRepository.existsByNomeAndAnnoAndIdNot(festival.getNome(), festival.getAnno(), festival.getId())) {
            throw new DuplicateFestivalException(festival.getNome(),festival.getAnno());
        }
    }
    return festivalRepository.save(festival);
}


}
