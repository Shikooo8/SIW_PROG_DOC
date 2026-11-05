package it.uniroma3.siw_festival.exception;

public class SalaInUsoException extends RuntimeException {
    public SalaInUsoException() {
        super("Impossibile cancellare la sala, annullare prima le proiezioni associate");
    }
}