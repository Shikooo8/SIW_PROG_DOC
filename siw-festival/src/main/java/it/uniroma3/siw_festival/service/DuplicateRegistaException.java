package it.uniroma3.siw_festival.service;

public class DuplicateRegistaException extends RuntimeException {
    public DuplicateRegistaException(String nome, String cognome) {
        super("Il film " + nome + " " + cognome + " è già presente nel sistema");
    }
}