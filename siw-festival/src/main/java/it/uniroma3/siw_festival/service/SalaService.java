package it.uniroma3.siw_festival.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw_festival.exception.DuplicateSalaException;
import it.uniroma3.siw_festival.model.Sala;
import it.uniroma3.siw_festival.repository.SalaRepository;

@Service 
public class SalaService {
           private SalaRepository salaRepository;

    
    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;

    }

    public Sala findById(Long id){
        return salaRepository.findById(id).get();
    }

    public List<Sala> findAll () {
        return (List<Sala>) salaRepository.findAll();
    }

  
    @Transactional 
    public Sala save(Sala sala) {
         if(salaRepository.existsByNomeAndIdNot(sala.getNome(), sala.getId())) {
            throw new DuplicateSalaException(sala.getNome());
            
        }
        return salaRepository.save(sala);
    }

    public void deleteById(Long id) {
       Sala sala = this.findById(id);
       this.salaRepository.delete(sala);
    }

}
