package it.uniroma3.siw_festival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;

import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.service.DuplicateFilmException;
import it.uniroma3.siw_festival.service.FilmService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller 
public class FilmController {
    @Autowired FilmService filmService;

    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }

    @PostMapping("/film")
    public String save(@Valid @ModelAttribute("film") Film film, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){  //controlla automaticamente la verifica dei vincoli e gli errori stanno in binding
            return "film/form.html";
        } 
        try{
            this.filmService.save(film);
            return "redirect:/movies";
        }
        catch(DuplicateFilmException e){
            bindingResult.reject("film.duplcate");  //registro un errore
            return "film/form";

        }
    }
    

    

}
