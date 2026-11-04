package it.uniroma3.siw_festival.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw_festival.model.Festival;
import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.exception.DuplicateFestivalException;
import it.uniroma3.siw_festival.exception.ImmagineNonValidaException;
import it.uniroma3.siw_festival.service.FestivalService;
import it.uniroma3.siw_festival.service.FilmService;
import jakarta.validation.Valid;

@Controller
public class FestivalController {

    private final FestivalService festivalService;
    private final FilmService filmService;

    public FestivalController(FestivalService festivalService, FilmService filmService) {
        this.festivalService = festivalService;
        this.filmService = filmService;
    }

    // #================================== PUBBLICO
    // ==================================

    @GetMapping("/festival")
    public String list(Model model) {
        model.addAttribute("festivals", festivalService.findAll());
        return "festival/list";
    }

    @GetMapping("/festival/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("festival", festivalService.findById(id));
        return "festival/show";
    }

    // #================================== ADMIN ==================================

    // 1. CREAZIONE: Nessun film, solo dati base del festival
    @GetMapping("/admin/festival/new")
    public String createForm(Model model) {
        model.addAttribute("festival", new Festival());
        return "admin/festival/form"; // Usa un file HTML dedicato
    }

    @PostMapping("/admin/festival/new")
    public String newFestival(@Valid @ModelAttribute("festival") Festival festival,
            BindingResult bindingResult,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        if (bindingResult.hasErrors()) {
            return "admin/festival/form";
        }
        try {
            festivalService.save(festival, file);
            return "redirect:/festival";
        } catch (DuplicateFestivalException e) {
            bindingResult.reject("festival.duplicate");
            return "admin/festival/form";
        } catch (ImmagineNonValidaException e) {
            bindingResult.reject("immagine.nonValida");
            return "admin/festival/form";
        }
    }

    // 2. MODIFICA: Qui carichiamo i film
    @GetMapping("/admin/festival/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("festival", festivalService.findById(id));
        model.addAttribute("films", filmService.findAll());
        return "admin/festival/formEdit"; // Usa il file con le checkbox
    }

    @PostMapping("/admin/festival/{id}/edit")
    public String saveEdit(@PathVariable Long id, @Valid @ModelAttribute("festival") Festival festival,
            BindingResult bindingResult, Model model, @RequestParam(value = "file", required = false) MultipartFile file) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("films", filmService.findAll());
            return "admin/festival/formEdit";
        }

        try {
            festival.setId(id);
            // 1. Recuperiamo il festival originale dal DB per conoscere la situazione
            // precedente
            Festival oldFestival = festivalService.findById(id);

            // 2. Rimuoviamo il festival dai film che sono stati DESELEZIONATI
            if (oldFestival.getFilm() != null) {
                for (Film f : oldFestival.getFilm()) {
                    if (festival.getFilm() == null || !festival.getFilm().contains(f)) {
                        f.getFestivals().remove(festival);
                        // Se Film è la parte proprietaria (owning side), dobbiamo salvarlo
                        filmService.save(f);
                    }
                }
            }

            // 3. Aggiungiamo il festival ai film che sono stati SELEZIONATI
            if (festival.getFilm() != null) {
                for (Film f : festival.getFilm()) {
                    if (!f.getFestivals().contains(festival)) {
                        f.getFestivals().add(festival);
                        // Salviamo il lato proprietario della relazione
                        filmService.save(f);
                    }
                }
            }

            // 4. Infine salviamo le modifiche del festival
            this.festivalService.save(festival, file);
            return "redirect:/festival";

        } catch (DuplicateFestivalException e) {
            bindingResult.reject("festival.duplicate");
            model.addAttribute("films", filmService.findAll());
            return "admin/festival/formEdit";
        }
    }

}