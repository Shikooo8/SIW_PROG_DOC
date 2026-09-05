package it.uniroma3.siw_festival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;

import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.service.DuplicateFilmException;
import it.uniroma3.siw_festival.service.FestivalService;
import it.uniroma3.siw_festival.service.FilmService;
import it.uniroma3.siw_festival.service.RegistaService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller 
public class FilmController {
    @Autowired FilmService filmService;
    private RegistaService registaService;
    private FestivalService festivalService;
    

    public FilmController(FilmService filmService, RegistaService registaService, FestivalService festivalService){
        this.filmService = filmService;
        this.festivalService = festivalService;
        this.registaService = registaService;
    }

    @PostMapping("/film")
    public String save(@Valid @ModelAttribute("film") Film film, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){  //controlla automaticamente la verifica dei vincoli e gli errori stanno in binding
            return "film/form";
        } 
        try{
            this.filmService.save(film);
            return "redirect:/film";
        }
        catch(DuplicateFilmException e){
            bindingResult.reject("film.duplcate");  //registro un errore
            return "film/form";

        }
    }

    // ---- pubblico ----
    
    @GetMapping("/film")
    public String list(Model model) {
        model.addAttribute("films", filmService.findAll());
        return "film/list";
    }
    
    @GetMapping("/film/{id}")
    public String show(@PathVariable Long id, Model model) {
        Film film = filmService.findById(id);
        model.addAttribute("film", film);
        // il template mostra film.getRegista(), film.getFestival(),
        // film.getProiezioni(), film.getRecensioni()
        return "film/show";
    }

    @GetMapping("/film/new")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public String form(Model model) {
        model.addAttribute("film", new Film());
        model.addAttribute("registi", registaService.findAll());
        return "film/form";
    }
    /* 
    // ---- admin ----
    
    
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String create(@Valid @ModelAttribute("film") Film film,
                          BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("registi", registaService.findAll());
            return "film/form";
        }
        Film saved = filmService.save(film);
        return "redirect:/film/" + saved.getId();
    }
    
    @GetMapping("/{id}/edit")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("film", filmService.findById(id));
        model.addAttribute("registi", registaService.findAll());
        return "film/form";
    }
    
    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String update(@PathVariable Long id,
                          @Valid @ModelAttribute("film") Film film,
                          BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("registi", registaService.findAll());
            return "film/form";
        }
        film.setId(id);
        filmService.save(film);
        return "redirect:/film/" + id;
    }
    
    // ---- associazione film <-> festival (admin) ----
    
    @PostMapping("/{filmId}/festival/{festivalId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addToFestival(@PathVariable Long filmId, @PathVariable Long festivalId) {
        filmService.addToFestival(filmId, festivalId);
        return "redirect:/film/" + filmId;
    }
    
    @DeleteMapping("/{filmId}/festival/{festivalId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String removeFromFestival(@PathVariable Long filmId, @PathVariable Long festivalId) {
        filmService.removeFromFestival(filmId, festivalId);
        return "redirect:/film/" + filmId;
    }
    */    


 

    

}
