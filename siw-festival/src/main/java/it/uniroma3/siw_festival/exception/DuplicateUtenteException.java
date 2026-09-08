package it.uniroma3.siw_festival.exception;

public class DuplicateUtenteException extends RuntimeException{
       public DuplicateUtenteException(String username) {
        super("Lo username '" + username + "' è già in uso");
    }
}
