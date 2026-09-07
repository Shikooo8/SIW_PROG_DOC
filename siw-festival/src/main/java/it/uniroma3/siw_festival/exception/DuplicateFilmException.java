package it.uniroma3.siw_festival.exception;

public class DuplicateFilmException extends RuntimeException {
    public DuplicateFilmException(String titolo, Integer anno) {
        super("Il film '" + titolo + "' (" + anno + ") è già presente nel sistema");
    }
}