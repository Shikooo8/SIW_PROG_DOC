package it.uniroma3.siw_festival.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw_festival.exception.DuplicateFestivalException;
import it.uniroma3.siw_festival.exception.ImmagineNonValidaException;
import it.uniroma3.siw_festival.model.Festival;
import it.uniroma3.siw_festival.model.Film;
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

    // ================================== PUBBLICO ==================================

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

    // ================================== ADMIN ==================================
    // Un solo form (admin/festival/form.html) per creazione e modifica

    // prepara la pagina: la lista dei film già scelti serve per mostrare i badge
    private String formView(List<Film> filmSelezionati, Model model) {
        model.addAttribute("filmSelezionati", filmSelezionati);
        return "admin/festival/form";
    }

    // se la form viene rimandata (errore), ricostruisce i film scelti partendo dagli id
    private List<Film> filmDaIds(List<Long> filmIds) {
        if (filmIds == null) {
            return new ArrayList<>();
        }
        return filmService.findAllById(filmIds);
    }

    @GetMapping("/admin/festival/new")
    public String createForm(Model model) {
        model.addAttribute("festival", new Festival());
        return formView(new ArrayList<>(), model);
    }

    @GetMapping("/admin/festival/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("festival", festivalService.findById(id));
        return formView(filmService.findByFestivalId(id), model);
    }

    // creazione e modifica: se il festival ha un id è una modifica
    @PostMapping("/admin/festival")
    public String save(@Valid @ModelAttribute("festival") Festival festival,
                       BindingResult bindingResult,
                       @RequestParam(value = "file", required = false) MultipartFile file,
                       @RequestParam(value = "filmIds", required = false) List<Long> filmIds,
                       Model model) {

        if (bindingResult.hasErrors()) {
            return formView(filmDaIds(filmIds), model);
        }
        try {
            Festival salvato = festivalService.save(festival, file, filmIds);
            return "redirect:/festival/" + salvato.getId();
        } catch (DuplicateFestivalException e) {
            bindingResult.reject("festival.duplicate");
            return formView(filmDaIds(filmIds), model);
        } catch (ImmagineNonValidaException e) {
            bindingResult.reject("immagine.nonValida");
            return formView(filmDaIds(filmIds), model);
        }
    }
}