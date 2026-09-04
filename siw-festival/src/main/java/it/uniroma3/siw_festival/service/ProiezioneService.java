package it.uniroma3.siw_festival.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.uniroma3.siw_festival.model.Proiezione;
import it.uniroma3.siw_festival.repository.ProiezioneRepository;

@Service 
public class ProiezioneService {
         private ProiezioneRepository proiezioneRepository;

    
    public ProiezioneService(ProiezioneRepository proiezioneRepository) {
        this.proiezioneRepository = proiezioneRepository;

    }

    public Proiezione findById(Long id){
        return proiezioneRepository.findById(id).get();
    }

    public List<Proiezione> findAll () {
        return (List<Proiezione>) proiezioneRepository.findAll();
    }



}
