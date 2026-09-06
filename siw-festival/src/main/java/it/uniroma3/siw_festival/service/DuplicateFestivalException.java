package it.uniroma3.siw_festival.service;

/**
 * DuplicateFestivalException
 */
public class DuplicateFestivalException extends RuntimeException{
        public DuplicateFestivalException(String nome, Integer anno) {
        super("Il festival '" + nome + "' (" + anno + ") è già presente nel sistema");
    }
}
