package it.uniroma3.siw_festival.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw_festival.exception.DuplicateSalaException;
import it.uniroma3.siw_festival.exception.SalaInUsoException;
import it.uniroma3.siw_festival.model.Sala;
import it.uniroma3.siw_festival.repository.ProiezioneRepository;
import it.uniroma3.siw_festival.repository.SalaRepository;

@Service
public class SalaService {
    private SalaRepository salaRepository;

    private ProiezioneRepository proiezioneRepository;

    public SalaService(SalaRepository salaRepository, ProiezioneRepository proiezioneRepository) {
        this.salaRepository = salaRepository;
        this.proiezioneRepository = proiezioneRepository;
    }

    public Sala findById(Long id) {
        return salaRepository.findById(id).get();
    }

    public List<Sala> findAll() {
        return (List<Sala>) salaRepository.findAll();
    }

    @Transactional
    public Sala save(Sala sala) throws DuplicateSalaException {
        boolean duplicata = (sala.getId() == null)
                ? salaRepository.existsByNomeIgnoreCase(sala.getNome())
                : salaRepository.existsByNomeIgnoreCaseAndIdNot(sala.getNome(), sala.getId());
        if (duplicata) {
            throw new DuplicateSalaException(sala.getNome());
        }
        return salaRepository.save(sala);
    }

    @Transactional
    public void deleteById(Long id) throws SalaInUsoException {
        if (proiezioneRepository.existsBySalaId(id)) {
            throw new SalaInUsoException();
        }
        salaRepository.deleteById(id);
    }
}
