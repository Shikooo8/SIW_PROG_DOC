package it.uniroma3.siw_festival.exception;

/**
 * DuplicateSalaException
 */
public class DuplicateSalaException extends RuntimeException{
    public DuplicateSalaException(String nome) {
        super("La sala " + nome + " è già presente nel sistema");
    }
}
