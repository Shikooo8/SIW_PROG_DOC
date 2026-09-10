package it.uniroma3.siw_festival.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;

import it.uniroma3.siw_festival.exception.DuplicateFilmException;
import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.model.Recensione;
import it.uniroma3.siw_festival.model.Regista;
import it.uniroma3.siw_festival.service.FestivalService;
import it.uniroma3.siw_festival.service.FilmService;
import it.uniroma3.siw_festival.service.RecensioneService;
import it.uniroma3.siw_festival.service.RegistaService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FilmController {

    private FilmService filmService;
    private RegistaService registaService;
    private FestivalService festivalService;
    private RecensioneService recensioneService;

    // Costruttore corretto per la Dependency Injection
    public FilmController(FilmService filmService, RegistaService registaService, FestivalService festivalService,
            RecensioneService recensioneService) {
        this.filmService = filmService;
        this.festivalService = festivalService;
        this.registaService = registaService;
        this.recensioneService = recensioneService;
    }

    @PostMapping("/film")
    public String save(@Valid @ModelAttribute("film") Film film, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            // IMPORTANTE: Ricarica sia i festival che i registi!
            model.addAttribute("festivals", festivalService.findAll());
            model.addAttribute("registi", registaService.findAll());
            return "admin/film/form";
        }
        try {
            // Salva PRIMA il nuovo regista nel DB, ma SOLO se stiamo creando uno nuovo (id
            // == null)
            if (film.getRegista() != null && film.getRegista().getId() == null) {
                this.registaService.save(film.getRegista());
            }

            this.filmService.save(film);
            return "redirect:/film";
        } catch (DuplicateFilmException e) {
            bindingResult.reject("film.duplicate");
            // Ricarica le liste anche qui
            model.addAttribute("festivals", festivalService.findAll());
            model.addAttribute("registi", registaService.findAll());
            return "admin/film/form";
        }
    }

    // ============================utente

    @GetMapping("/film")
    public String list(Model model) {
        List<Film> filmList = filmService.findAll();
        model.addAttribute("films", filmList);
        model.addAttribute("filmsNumber", filmList.size());
        return "film/list";
    }

    @GetMapping("/film/{id}")
    public String show(@PathVariable("id") Long id, Model model, Authentication authentication) {
        Film film = filmService.findById(id); // o il metodo che già usi
        model.addAttribute("film", film);

        boolean loggato = authentication != null
                && authentication.isAuthenticated()
                && !(authentication instanceof AnonymousAuthenticationToken);
        model.addAttribute("utenteLoggato", loggato);

        if (loggato) {
            Recensione recensioneUtente = recensioneService.findByFilmIdAndUsername(id, authentication.getName());
            model.addAttribute("recensioneUtente", recensioneUtente);
        }

        return "film/show";
    }

    @GetMapping("/film/new")
    public String form(Model model) {
        Film nuovoFilm = new Film();
        // Inizializza un Regista vuoto dentro il Film così Thymeleaf può legare i campi
        nuovoFilm.setRegista(new Regista());

        model.addAttribute("film", nuovoFilm);
        model.addAttribute("registi", registaService.findAll());
        model.addAttribute("festivals", festivalService.findAll());

        return "admin/film/form";
    }

    @GetMapping("/film/{id}/recensioni")
    public String recensioni(@PathVariable Long id, Model model) {
        Film film = filmService.findById(id);
        model.addAttribute("film", film);
        return "film/recensioni";
    }

    @GetMapping("/film/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Film filmDaModificare = filmService.findById(id);

        // Se il film non ha un regista, ne impostiamo uno vuoto per non far crashare la
        // form
        if (filmDaModificare.getRegista() == null) {
            filmDaModificare.setRegista(new Regista());
        }

        model.addAttribute("film", filmDaModificare);
        model.addAttribute("registi", registaService.findAll());
        model.addAttribute("festivals", festivalService.findAll());

        return "admin/film/formEdit";
    }
}
