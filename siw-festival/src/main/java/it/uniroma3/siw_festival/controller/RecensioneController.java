package it.uniroma3.siw_festival.controller;

import java.time.LocalDateTime;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw_festival.dto.RecensioneForm;
import it.uniroma3.siw_festival.exception.DuplicateRecensioneException;
import it.uniroma3.siw_festival.exception.RecensioneUnauthorizedException;
import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.model.Recensione;
import it.uniroma3.siw_festival.model.Utente;
import it.uniroma3.siw_festival.service.FilmService;
import it.uniroma3.siw_festival.service.RecensioneService;
import jakarta.validation.Valid;

@Controller
public class RecensioneController {

    private final RecensioneService recensioneService;
    private final FilmService filmService;

    public RecensioneController(RecensioneService recensioneService, FilmService filmService) {
        this.recensioneService = recensioneService;
        this.filmService = filmService;
    }

    // ---------- NUOVA RECENSIONE ----------

    @GetMapping("/film/{filmId}/recensione/new")
    public String newForm(@PathVariable Long filmId, Model model, Authentication authentication) {
        Film film = filmService.findById(filmId);

        // Non permettere di aprire la form se esiste già una recensione dell'utente
        if (recensioneService.findByFilmIdAndUsername(filmId, authentication.getName()) != null) {
            return "redirect:/film/" + filmId;
        }

        model.addAttribute("film", film);
        model.addAttribute("recensioneForm", new RecensioneForm());
        return "recensione/form";
    }

    @PostMapping("/film/{filmId}/recensione")
    public String save(@PathVariable Long filmId,
                        @Valid @ModelAttribute("recensioneForm") RecensioneForm form,
                        BindingResult bindingResult,
                        Model model,
                        Authentication authentication) {

        Film film = filmService.findById(filmId);

        if (bindingResult.hasErrors()) {
            model.addAttribute("film", film);
            return "recensione/form";
        }

        Utente utente = recensioneService.getUtenteByUsername(authentication.getName());

        Recensione recensione = new Recensione();
        recensione.setTesto(form.getTesto());
        recensione.setVoto(form.getVoto());
        recensione.setData(LocalDateTime.now());
        recensione.setFilm(film);
        recensione.setUtente(utente);

        try {
            recensioneService.save(recensione);
        } catch (DuplicateRecensioneException e) {
            bindingResult.reject("recensione.duplicate", e.getMessage());
            model.addAttribute("film", film);
            return "recensione/form";
        }

        return "redirect:/film/" + filmId;
    }

    // ---------- MODIFICA RECENSIONE ----------

    @GetMapping("/recensione/{id}/edit")
    public String editForm(@PathVariable Long id, Model model, Authentication authentication) {
        Recensione recensione = recensioneService.findById(id);

        if (!recensione.getUtente().getUsername().equals(authentication.getName())) {
            throw new RecensioneUnauthorizedException();
        }

        RecensioneForm form = new RecensioneForm();
        form.setTesto(recensione.getTesto());
        form.setVoto(recensione.getVoto());

        model.addAttribute("recensioneForm", form);
        model.addAttribute("film", recensione.getFilm());
        model.addAttribute("recensioneId", id);
        return "recensione/editForm";
    }

    @PostMapping("/recensione/{id}/edit")
    public String update(@PathVariable Long id,
                          @Valid @ModelAttribute("recensioneForm") RecensioneForm form,
                          BindingResult bindingResult,
                          Model model,
                          Authentication authentication) {

        Recensione recensione = recensioneService.findById(id);

        if (bindingResult.hasErrors()) {
            model.addAttribute("film", recensione.getFilm());
            model.addAttribute("recensioneId", id);
            return "recensione/editForm";
        }

        // update() dentro al service verifica già la proprietà e lancia
        // RecensioneUnauthorizedException se username non combacia
        recensioneService.update(id, form.getTesto(), form.getVoto(), authentication.getName());

        return "redirect:/film/" + recensione.getFilm().getId();
    }

    // ---------- ELIMINA RECENSIONE ----------

    @PostMapping("/recensione/{id}/delete")
    public String delete(@PathVariable Long id, Authentication authentication) {
        Recensione recensione = recensioneService.findById(id);
        Long filmId = recensione.getFilm().getId();

        recensioneService.delete(id, authentication.getName());

        return "redirect:/film/" + filmId;
    }
}