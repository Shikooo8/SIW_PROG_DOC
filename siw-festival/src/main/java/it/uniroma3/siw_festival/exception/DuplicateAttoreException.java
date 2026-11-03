package it.uniroma3.siw_festival.exception;

public class DuplicateAttoreException extends RuntimeException {
    public DuplicateAttoreException(String nome, String cognome) {
        super("Il film " + nome + " " + cognome + " è già presente nel sistema");
    }
}