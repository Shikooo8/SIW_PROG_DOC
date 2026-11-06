package it.uniroma3.siw_festival.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import it.uniroma3.siw_festival.exception.FilmNotFoundException;

@RestControllerAdvice(basePackages = "it.uniroma3.siw_festival.controller.rest")
public class RestExceptionHandler {
    @ExceptionHandler(FilmNotFoundException.class)
    public ResponseEntity<String> notFound(FilmNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
