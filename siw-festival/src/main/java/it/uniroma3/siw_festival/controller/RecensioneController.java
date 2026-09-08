package it.uniroma3.siw_festival.controller;
package it.uniroma3.siw_festival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.model.Recensione;
import it.uniroma3.siw_festival.service.FilmService;
//import it.uniroma3.siw_festival.service.RecensioneService;

import java.time.LocalDate;

@Controller
public class RecensioneController {

    private RecensioneService recensioneService;
    
    private FilmService filmService;

    @GetMapping("/recensione/new/{filmId}")
    public String formRecensione(@PathVariable Long filmId, Model model) {
        Film film = filmService.findById(filmId);
        Recensione recensione = new Recensione();
        
        model.addAttribute("recensione", recensione);
        model.addAttribute("film", film);
        return "recensione/form";
    }

    @PostMapping("/recensione/new/{filmId}")
    public String saveRecensione(@PathVariable Long filmId, 
                                 @Valid @ModelAttribute("recensione") Recensione recensione, 
                                 BindingResult bindingResult, Model model) {
        Film film = filmService.findById(filmId);
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("film", film);
            return "recensione/form";
        }

        try {
            // Imposta i dati automatici
            recensione.setFilm(film);
            recensione.setData(LocalDate.now());
            
            // TODO: Quando implementerai Spring Security, qui dovrai:
            // 1. Recuperare l'utente loggato
            // 2. Controllare se ha già recensito questo film (lanciare eccezione se vero)[cite: 1]
            // 3. recensione.setUtente(utenteLoggato);

            this.recensioneService.save(recensione);
            return "redirect:/film/" + filmId; // Torna al dettaglio del film
            
        } catch (Exception e) {
            bindingResult.reject("recensione.errore", "Errore durante il salvataggio della recensione.");
            model.addAttribute("film", film);
            return "recensione/form";
        }
    }
}