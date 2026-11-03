package it.uniroma3.siw_festival.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.uniroma3.siw_festival.exception.DuplicateAttoreException;
import it.uniroma3.siw_festival.model.Attore;
import it.uniroma3.siw_festival.repository.AttoreRepository;
import jakarta.transaction.Transactional;

@Service 
public class AttoreService {
       private AttoreRepository registaRepository;

    
    public AttoreService(AttoreRepository registaRepository) {
        this.registaRepository = registaRepository;

    }

    public Attore findById(Long id){
        return registaRepository.findById(id).get();
    }

    public List<Attore> findAll () {
        return (List<Attore>) registaRepository.findAll();
    }

    @Transactional 
    public Attore save(Attore regista) {
         if(registaRepository.existsByNomeAndCognome(regista.getNome(), regista.getCognome())) {
            throw new DuplicateAttoreException(regista.getNome(), regista.getCognome());
            
        }
        return registaRepository.save(regista);
    }

    public void deleteById(Long id) {
          Attore regista = this.findById(id);
        registaRepository.delete(regista);
    }

    

}
