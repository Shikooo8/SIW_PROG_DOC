package it.uniroma3.siw_festival.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw_festival.exception.DuplicateUtenteException;
import it.uniroma3.siw_festival.model.Utente;
import it.uniroma3.siw_festival.repository.UtenteRepository;

@Service 
public class UtenteService {
    
    
    private final UtenteRepository utenteRepository;
    private final PasswordEncoder passwordEncoder;
    
    public UtenteService(UtenteRepository utenteRepository, PasswordEncoder passwordEncoder) {
        this.utenteRepository = utenteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Utente registra(Utente utente) {
        if (utenteRepository.existsByUsername(utente.getUsername())) {
            throw new DuplicateUtenteException(utente.getUsername());
        }
        utente.setPassword(passwordEncoder.encode(utente.getPassword())); 
        utente.setRuolo(Utente.USER_ROLE); 
        return utenteRepository.save(utente);
    }

}
