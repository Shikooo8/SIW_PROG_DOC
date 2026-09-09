package it.uniroma3.siw_festival.exception;

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

  

    @ExceptionHandler(Exception.class)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public String handleUnexpectedException(Exception e, Model model) {
    e.printStackTrace(); // lo stampa comunque in console
    model.addAttribute("errorMessage", e.toString());
    model.addAttribute("stackTrace", 
        java.util.Arrays.stream(e.getStackTrace())
            .limit(20)
            .map(Object::toString)
            .collect(java.util.stream.Collectors.joining("\n")));
    return "error/500";
}

@ExceptionHandler(RecensioneUnauthorizedException.class)
@ResponseStatus(HttpStatus.FORBIDDEN)
public String handleRecensioneUnauthorized(RecensioneUnauthorizedException e, Model model) {
    model.addAttribute("errorMessage", "Non sei autorizzato a modificare questa recensione.");
    return "error/403"; // crea questo template sul modello di error/404, se non esiste già
}

}
