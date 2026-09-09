package it.uniroma3.siw_festival.controller;

import java.util.HashMap;
import java.util.Map;

import jakarta.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import it.uniroma3.siw_festival.exception.DuplicateRecensioneException;
import it.uniroma3.siw_festival.exception.RecensioneNotFoundException;
import it.uniroma3.siw_festival.exception.RecensioneUnauthorizedException;

@RestControllerAdvice(assignableTypes = { RecensioneRestController.class, UtenteRestController.class })
public class RecensioneRestExceptionHandler {

    @ExceptionHandler(RecensioneNotFoundException.class)
    public ResponseEntity<Map<String, String>> notFound(RecensioneNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error(e.getMessage()));
    }

    @ExceptionHandler(DuplicateRecensioneException.class)
    public ResponseEntity<Map<String, String>> duplicate(DuplicateRecensioneException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error(e.getMessage()));
    }

    @ExceptionHandler(RecensioneUnauthorizedException.class)
    public ResponseEntity<Map<String, String>> unauthorized(RecensioneUnauthorizedException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error(e.getMessage()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> validation(ConstraintViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error("Dati non validi: " + e.getMessage()));
    }

    private Map<String, String> error(String message) {
        Map<String, String> body = new HashMap<>();
        body.put("error", message);
        return body;
    }
}