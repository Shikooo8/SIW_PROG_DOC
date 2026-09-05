package it.uniroma3.siw_festival.service;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice 
public class GlobalExceptionHandler {


    @ExceptionHandler (FilmNotFoundException.class)
    @ResponseStatus (HttpStatus.NOT_FOUND)
    public String handleFilmNotFound(FilmNotFoundException e, Model model){
        model.addAttribute("errorMessage", e.getMessage());
        return "error/404";
    }

    /*@ExceptionHandler (FilmNotFound.class)
    public String handleFilmNotFound(FilmNotFoundException e, Model model){
        model.addAttribute("errorMessage", e.getMessage());
        return "error/film-not-found";
    }*/

    @ExceptionHandler (Exception.class)
    @ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUnexpectedException(Exception e, Model model){
        model.addAttribute("errorMessage", "Si è verificato un errore interno. Riprovare più tardi.");
        return "error/500";
    }

}
