package it.uniroma3.siw_festival.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw_festival.exception.OverlappingProiezioneException;
import it.uniroma3.siw_festival.model.Proiezione;
import it.uniroma3.siw_festival.model.Recensione;
import it.uniroma3.siw_festival.repository.ProiezioneRepository;
import jakarta.validation.Valid;

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

    public List<Proiezione> findProiezioniByFestivalId(Long id) {
              
        return (List<Proiezione>) proiezioneRepository.findAll();

    }


    @Transactional
    public void delete(Proiezione proiezione) {
        this.proiezioneRepository.delete(proiezione);
    }

  @Transactional
    public void deleteId(Long id) {
        Proiezione proiezione = this.findById(id);
        proiezioneRepository.delete(proiezione);
    }

  @Transactional
    public Proiezione save(Proiezione nuovaProiezione) throws OverlappingProiezioneException {
        
        // 1. Prendi tutte le proiezioni per quella sala in quella giornata
        List<Proiezione> proiezioniDelGiorno = proiezioneRepository.findBySalaAndData(
                nuovaProiezione.getSala(), 
                nuovaProiezione.getData()
        );

        // 2. Calcola l'orario di fine della nuova proiezione aggiungendo i minuti di durata
        LocalTime inizioNuova = nuovaProiezione.getOra();
        LocalTime fineNuova = inizioNuova.plusMinutes(nuovaProiezione.getFilm().getDurata());

        // 3. Controlla le sovrapposizioni
        for (Proiezione esistente : proiezioniDelGiorno) {
            
            // Se stiamo facendo un "Update", ignoriamo la proiezione stessa
            if (esistente.getId().equals(nuovaProiezione.getId())) {
                continue;
            }

            LocalTime inizioEsistente = esistente.getOra();
            LocalTime fineEsistente = inizioEsistente.plusMinutes(esistente.getFilm().getDurata());

            // LOGICA DI OVERLAP: C'è sovrapposizione se la nuova inizia prima che la vecchia finisca 
            // e finisce dopo che la vecchia è iniziata.
            if (inizioNuova.isBefore(fineEsistente) && fineNuova.isAfter(inizioEsistente)) {
                
                String messaggioErrore = String.format(
                    "La sala è occupata dal film '%s' (dalle %s alle %s)", 
                    esistente.getFilm().getTitolo(), inizioEsistente.toString(), fineEsistente.toString()
                );
                
                throw new OverlappingProiezioneException(messaggioErrore);
            }
        }

        // Se il ciclo finisce senza eccezioni, la sala è libera!
        return proiezioneRepository.save(nuovaProiezione);
    }


}
