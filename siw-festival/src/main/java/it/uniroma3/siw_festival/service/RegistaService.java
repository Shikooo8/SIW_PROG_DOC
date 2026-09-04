package it.uniroma3.siw_festival.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.uniroma3.siw_festival.model.Regista;
import it.uniroma3.siw_festival.repository.RegistaRepository;

@Service 
public class RegistaService {
       private RegistaRepository registaRepository;

    
    public RegistaService(RegistaRepository registaRepository) {
        this.registaRepository = registaRepository;

    }

    public Regista findById(Long id){
        return registaRepository.findById(id).get();
    }

    public List<Regista> findAll () {
        return (List<Regista>) registaRepository.findAll();
    }


}
