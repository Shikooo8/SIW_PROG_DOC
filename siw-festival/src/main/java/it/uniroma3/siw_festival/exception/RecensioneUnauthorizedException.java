package it.uniroma3.siw_festival.exception;

public class RecensioneUnauthorizedException extends RuntimeException {
    public RecensioneUnauthorizedException() {
        super("Non sei autorizzato a modificare o eliminare questa recensione");
    }
}