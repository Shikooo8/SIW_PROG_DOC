package it.uniroma3.siw_festival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw_festival.service.FilmService;

@Controller 
public class FilmController {
    @Autowired FilmService filmService;

    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }


    

}
