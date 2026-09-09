package it.uniroma3.siw_festival.exception;

public class DuplicateRecensioneException extends RuntimeException {
    public DuplicateRecensioneException(String filmTitolo, String utenteUsername){
        super("L'utente " + utenteUsername + " ha già scritto una recensione per il film " + filmTitolo);


    }
    
}