package it.uniroma3.siw_festival.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw_festival.exception.DuplicateAttoreException;
import it.uniroma3.siw_festival.model.Attore;
import it.uniroma3.siw_festival.repository.AttoreRepository;

@Service
public class AttoreService {
    private AttoreRepository attoreRepository;

    public AttoreService(AttoreRepository attoreRepository) {
        this.attoreRepository = attoreRepository;
    }

    public Attore findById(Long id) {
        return attoreRepository.findById(id).get();
    }

    public List<Attore> findAll() {
        List<Attore> lista = new ArrayList<>();
        attoreRepository.findAll().forEach(lista::add);
        return lista;
    }

    @Transactional
    public Attore save(Attore attore) {
        if (attoreRepository.existsByNomeAndCognome(attore.getNome(), attore.getCognome())) {
            throw new DuplicateAttoreException(attore.getNome(), attore.getCognome());

        }
        return attoreRepository.save(attore);
    }

    public void deleteById(Long id) {
        Attore attore = this.findById(id);
        attoreRepository.delete(attore);
    }

    @Transactional(readOnly = true)
    public List<Attore> cerca(String prefisso) {
        if (prefisso == null || prefisso.isBlank()) {
            return List.of();
        }
        String p = prefisso.trim();
        return attoreRepository
                .findTop15ByCognomeStartingWithIgnoreCaseOrNomeStartingWithIgnoreCaseOrderByCognomeAscNomeAsc(p, p);
    }

    @Transactional
    public Attore update(Long id, Attore dati) throws DuplicateAttoreException {
        if (attoreRepository.existsByNomeAndCognomeAndIdNot(dati.getNome(), dati.getCognome(), id)) {
            throw new DuplicateAttoreException(dati.getNome(), dati.getCognome());
        }
        Attore attore = this.findById(id); // carico quello esistente dal DB
        attore.setNome(dati.getNome());
        attore.setCognome(dati.getCognome());
        attore.setDataNascita(dati.getDataNascita());
        attore.setNazionalità(dati.getNazionalità());
        return attoreRepository.save(attore);
    }

}
