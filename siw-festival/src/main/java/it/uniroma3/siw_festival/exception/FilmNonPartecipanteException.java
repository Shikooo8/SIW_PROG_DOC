package it.uniroma3.siw_festival.exception;

public class FilmNonPartecipanteException extends RuntimeException {
    public FilmNonPartecipanteException(String film, String festival) {
        super("Il film '" + film + "' non partecipa al festival '" + festival + "'");
    }
}
