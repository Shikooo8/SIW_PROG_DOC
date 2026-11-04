package it.uniroma3.siw_festival.controller;

import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw_festival.dto.FilmForm;
import it.uniroma3.siw_festival.dto.InterpretazioneForm;
import it.uniroma3.siw_festival.exception.CastNonValidoException;
import it.uniroma3.siw_festival.exception.DuplicateFilmException;
import it.uniroma3.siw_festival.exception.ImmagineNonValidaException;
import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.service.FestivalService;
import it.uniroma3.siw_festival.service.FilmService;
import it.uniroma3.siw_festival.service.RecensioneService;
import jakarta.validation.Valid;

@Controller
public class FilmController {

    private final FilmService filmService;
    private final FestivalService festivalService;
    private final RecensioneService recensioneService;

    public FilmController(FilmService filmService, FestivalService festivalService,
            RecensioneService recensioneService) {
        this.filmService = filmService;
        this.festivalService = festivalService;
        this.recensioneService = recensioneService;
    }

    // ================================== PUBBLICO
    // ==================================

    @GetMapping("/film")
    public String list(@RequestParam(defaultValue = "") String q,
            @RequestParam(defaultValue = "0") int page, Model model) {

        String ricerca = (q == null) ? "" : q; // se q è null usa "", altrimenti q
        Page<Film> pagina = filmService.cercaPagina(ricerca, page);

        model.addAttribute("films", pagina.getContent());
        model.addAttribute("pagina", pagina);
        model.addAttribute("q", ricerca); // il template usa questo
        model.addAttribute("filmsNumber", pagina.getTotalElements());
        return "film/list";
    }

    @GetMapping("/film/{id}")
    public String show(@PathVariable("id") Long id, Model model, Authentication authentication) {
        model.addAttribute("film", filmService.findById(id));
        model.addAttribute("mediaVoti", recensioneService.mediaVoti(id));

        boolean loggato = authentication != null
                && !(authentication instanceof AnonymousAuthenticationToken);
        model.addAttribute("utenteLoggato", loggato);

        if (loggato) {
            model.addAttribute("recensioneUtente",
                    recensioneService.findByFilmIdAndUsername(id, authentication.getName()));
        }
        return "film/show";
    }

    // ================================== ADMIN ==================================
    // Un solo form (admin/film/form.html) per creazione e modifica

    // prepara la pagina: i festival già scelti servono per mostrare i badge
    private String formView(FilmForm form, Model model) {
        model.addAttribute("festivalsSelezionati", festivalService.findAllById(form.getFestivalIds()));
        return "admin/film/form";
    }

    @GetMapping("/admin/film/new")
    public String newForm(Model model) {
        FilmForm form = new FilmForm();
        model.addAttribute("film", form);
        return formView(form, model);
    }

    @GetMapping("/admin/film/{id}/edit")
    public String editForm(@PathVariable("id") Long id, Model model) {
        FilmForm form = filmService.getFilmForm(id);
        model.addAttribute("film", form);
        return formView(form, model);
    }

    // bottone "Aggiungi personaggio": aggiunge una riga vuota al cast
    @PostMapping("/admin/film/cast/add")
    public String addCast(@ModelAttribute("film") FilmForm form, Model model) {
        form.getCast().add(new InterpretazioneForm());
        return formView(form, model);
    }

    // bottone "Rimuovi": toglie la riga con quell'indice
    @PostMapping("/admin/film/cast/{index}/remove")
    public String removeCast(@ModelAttribute("film") FilmForm form,
            @PathVariable("index") int index, Model model) {
        if (index >= 0 && index < form.getCast().size()) {
            form.getCast().remove(index);
        }
        return formView(form, model);
    }

    // salvataggio (creazione e modifica: se il film ha un id è una modifica)
    @PostMapping("/admin/film")
    public String salvaFilm(@Valid @ModelAttribute("film") FilmForm form,
            BindingResult bindingResult,
            @RequestParam(value = "file", required = false) MultipartFile file,
            Model model) {

        if (bindingResult.hasErrors()) {
            return formView(form, model);
        }
        try {
            Film salvato = filmService.save(form, file);
            return "redirect:/film/" + salvato.getId();
        } catch (DuplicateFilmException e) {
            bindingResult.reject("film.duplicato");
        } catch (CastNonValidoException e) {
            bindingResult.reject("film.cast", e.getMessage());
        } catch (ImmagineNonValidaException e) {
            bindingResult.reject("immagine.nonValida");
        }
        // si arriva qui solo se è stata catturata un'eccezione: rimostra il form con
        // l'errore
        return formView(form, model);
    }
}