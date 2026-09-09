package it.uniroma3.siw_festival.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.model.Recensione;
import it.uniroma3.siw_festival.model.Utente;
import it.uniroma3.siw_festival.service.FilmService;
import it.uniroma3.siw_festival.service.RecensioneService;

@RestController
@RequestMapping("/api")
public class RecensioneRestController {

    private final RecensioneService recensioneService;
    private final FilmService filmService;

    public RecensioneRestController(RecensioneService recensioneService, FilmService filmService) {
        this.recensioneService = recensioneService;
        this.filmService = filmService;
    }

    @GetMapping("/film/{filmId}/recensioni")
    public List<Recensione> getRecensioni(@PathVariable Long filmId) {
        return recensioneService.findByFilmId(filmId);
    }

    @PostMapping("/film/{filmId}/recensione")
    public ResponseEntity<Recensione> creaRecensione(@PathVariable Long filmId,
                                                       @RequestBody Recensione recensioneInput,
                                                       Authentication authentication) {
        Film film = filmService.findById(filmId);
        Utente utente = recensioneService.getUtenteByUsername(authentication.getName());

        Recensione recensione = new Recensione();
        recensione.setTesto(recensioneInput.getTesto());
        recensione.setVoto(recensioneInput.getVoto());
        recensione.setData(LocalDateTime.now());
        recensione.setFilm(film);
        recensione.setUtente(utente);

        Recensione salvata = recensioneService.save(recensione);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvata);
    }

    @PutMapping("/recensione/{id}")
    public Recensione modificaRecensione(@PathVariable Long id,
                                          @RequestBody Recensione recensioneInput,
                                          Authentication authentication) {
        return recensioneService.update(id, recensioneInput.getTesto(), recensioneInput.getVoto(),
                authentication.getName());
    }

    @DeleteMapping("/recensione/{id}")
    public ResponseEntity<Void> eliminaRecensione(@PathVariable Long id, Authentication authentication) {
        recensioneService.delete(id, authentication.getName());
        return ResponseEntity.noContent().build();
    }
}