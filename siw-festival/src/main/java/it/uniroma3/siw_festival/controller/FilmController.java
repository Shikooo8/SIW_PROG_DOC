package it.uniroma3.siw_festival.controller;

import java.util.List;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import it.uniroma3.siw_festival.dto.FilmForm;
import it.uniroma3.siw_festival.dto.InterpretazioneForm;
import it.uniroma3.siw_festival.exception.CastNonValidoException;
import it.uniroma3.siw_festival.exception.DuplicateFilmException;
import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.model.Recensione;
import it.uniroma3.siw_festival.service.FestivalService;
import it.uniroma3.siw_festival.service.FilmService;
import it.uniroma3.siw_festival.service.RecensioneService;
import it.uniroma3.siw_festival.service.AttoreService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmController {

    private FilmService filmService;
    private AttoreService attoreService;
    private FestivalService festivalService;
    private RecensioneService recensioneService;

    // Costruttore corretto per la Dependency Injection
    public FilmController(FilmService filmService, AttoreService attoreService, FestivalService festivalService,
            RecensioneService recensioneService) {
        this.filmService = filmService;
        this.festivalService = festivalService;
        this.attoreService = attoreService;
        this.recensioneService = recensioneService;
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

        boolean loggato = authentication != null && authentication.isAuthenticated()
                && !(authentication instanceof AnonymousAuthenticationToken);
        model.addAttribute("utenteLoggato", loggato);

        if (loggato) {
            Recensione recensioneUtente = recensioneService.findByFilmIdAndUsername(id, authentication.getName());
            model.addAttribute("recensioneUtente", recensioneUtente);
        }

        return "film/show";
    }

    // serve davvero? TODO
    @GetMapping("/film/{id}/recensioni")
    public String recensioni(@PathVariable Long id, Model model) {
        Film film = filmService.findById(id);
        model.addAttribute("film", film);
        return "film/recensioni";
    }

    // ====================== non chiaro ==================================

    private String formView(Model model) {
        model.addAttribute("attori", attoreService.findAll());
        model.addAttribute("festivals", festivalService.findAll());
        return "admin/film/form";
    }

    @GetMapping("/admin/film/new")
    public String newForm(Model model) {
        model.addAttribute("film", new FilmForm());
        return formView(model);
    }

    @GetMapping("/admin/film/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("film", filmService.getFilmForm(id));
        return formView(model);
    }

    @PostMapping("/admin/film/cast/add")
    public String addCast(@ModelAttribute("film") FilmForm form, Model model) {
        form.getCast().add(new InterpretazioneForm());
        return formView(model);
    }

    @PostMapping("/admin/film/cast/{index}/remove")
    public String removeCast(@ModelAttribute("film") FilmForm form,
            @PathVariable("index") int index, Model model) {
        if (index >= 0 && index < form.getCast().size()) {
            form.getCast().remove(index);
        }
        return formView(model);
    }

    @PostMapping("/admin/film")
    public String save(@Valid @ModelAttribute("film") FilmForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return formView(model);
        }
        try {
            Film salvato = filmService.save(form);
            return "redirect:/film/" + salvato.getId();
        } catch (DuplicateFilmException e) {
            bindingResult.reject("film.duplicato");
            return formView(model);
        } catch (CastNonValidoException e) {
            bindingResult.reject("film.cast", e.getMessage());
            return formView(model);
        }
    }
}