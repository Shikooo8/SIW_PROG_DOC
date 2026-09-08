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

    public Utente getUtente(Long id){
        //TODO
        return null;
    }    


    @Transactional
    public Utente registra(Utente utente) {
        if (utenteRepository.existsByUsername(utente.getUsername())) {
            throw new DuplicateUtenteException(utente.getUsername());
        }
        utente.setPassword(passwordEncoder.encode(utente.getPassword())); // MAI salvare in chiaro
        utente.setRuolo(Utente.USER_ROLE); // il ruolo   NON arriva mai dal form: lo decide il server
        return utenteRepository.save(utente);
    }

}
