package it.uniroma3.siw_festival.exception;

/**
 * FilmNotFoundException
 */
public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException(Long id){
        super("Il film con ID " + id + " non esiste");
    }
}
