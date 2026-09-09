package it.uniroma3.siw_festival.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UtenteRestController {

    @GetMapping("/utente/me")
    public ResponseEntity<Map<String, Object>> me(Authentication authentication) {
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return ResponseEntity.ok(Map.of("autenticato", false));
        }
        return ResponseEntity.ok(Map.of(
                "autenticato", true,
                "username", authentication.getName()
        ));
    }
}