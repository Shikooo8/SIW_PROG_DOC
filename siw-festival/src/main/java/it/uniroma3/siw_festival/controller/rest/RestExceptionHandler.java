package it.uniroma3.siw_festival.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import it.uniroma3.siw_festival.exception.FilmNotFoundException;

@RestControllerAdvice(basePackages = "it.uniroma3.siw_festival.controller.rest")
public class RestExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
    @ExceptionHandler(FilmNotFoundException.class)
    public ResponseEntity<String> notFound(FilmNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception e) {
        logger.error("Errore REST", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Errore interno");
    }
}
