package it.uniroma3.siw_festival.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import it.uniroma3.siw_festival.model.Utente;
import it.uniroma3.siw_festival.repository.UtenteRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;


@Service
public class CustomOidcUserService extends OidcUserService {

    private final UtenteRepository utenteRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomOidcUserService(UtenteRepository utenteRepository,
                                 PasswordEncoder passwordEncoder) {
        this.utenteRepository = utenteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public OidcUser loadUser(OidcUserRequest request) {
        OidcUser oidcUser = super.loadUser(request);
        String email = oidcUser.getEmail();

        // cerca l'utente; se non esiste lo crea con ruolo DEFAULT
        Utente utente = utenteRepository.findByUsername(email).orElseGet(() -> {
            Utente nuovo = new Utente();
            nuovo.setUsername(email);
            nuovo.setPassword(passwordEncoder.encode(UUID.randomUUID().toString()));
            nuovo.setRuolo(Utente.DEFAULT_ROLE);
            return utenteRepository.save(nuovo);
        });

        // le authority vengono dal TUO database, non da Google
        return new DefaultOidcUser(List.of(new SimpleGrantedAuthority(utente.getRuolo())), oidcUser.getIdToken(), oidcUser.getUserInfo(), "email");
    }
}