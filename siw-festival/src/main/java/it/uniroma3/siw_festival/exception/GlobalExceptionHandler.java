package it.uniroma3.siw_festival.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 404: risorsa applicativa inesistente (es. /film/999)
    @ExceptionHandler(FilmNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleFilmNotFound(FilmNotFoundException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "error/404";
    }

    // 404: URL inesistente (nessun controller lo gestisce)
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoResourceFound() {
        return "error/404";
    }

    // 403: recensione di un altro utente
    @ExceptionHandler(RecensioneUnauthorizedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleRecensioneUnauthorized(Model model) {
        model.addAttribute("errorMessage", "Non sei autorizzato a modificare questa recensione.");
        return "error/403";
    }

    // 403: accesso negato lanciato dal codice (non dai filtri di Security)
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleAccessDenied() {
        return "error/403";
    }

    // 413: upload troppo grande
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
    public String handleFileTroppoGrande(Model model) {
        model.addAttribute("errorMessage", "Il file è troppo grande (massimo 5MB).");
        return "error/4xx";
    }

    // 500: qualunque altra cosa. Il dettaglio va nel log, MAI nella pagina
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUnexpected(Exception e) {
        logger.error("Errore inatteso", e);
        return "error/500";
    }
}