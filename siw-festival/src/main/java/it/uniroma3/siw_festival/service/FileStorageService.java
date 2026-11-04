package it.uniroma3.siw_festival.service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw_festival.exception.ImmagineNonValidaException;

@Service
public class FileStorageService {

    private static final Logger logger = LoggerFactory.getLogger(FileStorageService.class);

    private static final Set<String> ESTENSIONI = Set.of("jpg", "jpeg", "png", "webp");
    private static final Set<String> CONTENT_TYPES = Set.of("image/jpeg", "image/png", "image/webp");

    private final Path root;

    public FileStorageService(@Value("${app.upload-dir}") String uploadDir) throws IOException {
        this.root = Paths.get(uploadDir).toAbsolutePath().normalize();
        Files.createDirectories(this.root);
    }

    /** Salva il file e ritorna il percorso relativo (es. "films/uuid.jpg"). Ritorna null se non c'è file. */
    public String store(MultipartFile file, String sottocartella) {
        if (file == null || file.isEmpty()) {
            return null;
        }
        if (!CONTENT_TYPES.contains(file.getContentType())) {
            throw new ImmagineNonValidaException("Sono ammesse solo immagini JPG, PNG o WEBP");
        }
        String estensione = estensione(file.getOriginalFilename());
        if (!ESTENSIONI.contains(estensione)) {
            throw new ImmagineNonValidaException("Estensione non ammessa");
        }
        // il nome originale NON viene mai usato: evita path traversal e collisioni
        String nomeFile = UUID.randomUUID() + "." + estensione;
        try {
            Path cartella = root.resolve(sottocartella);
            Files.createDirectories(cartella);
            file.transferTo(cartella.resolve(nomeFile));
        } catch (IOException e) {
            throw new UncheckedIOException("Impossibile salvare l'immagine", e);
        }
        return sottocartella + "/" + nomeFile;
    }

    /** Cancella un file dato il percorso relativo salvato nel DB. */
    public void delete(String percorsoRelativo) {
        if (percorsoRelativo == null) {
            return;
        }
        Path file = root.resolve(percorsoRelativo).normalize();
        if (!file.startsWith(root)) {   // sicurezza: non uscire dalla cartella uploads
            return;
        }
        try {
            Files.deleteIfExists(file);
        } catch (IOException e) {
            logger.warn("Impossibile cancellare il file {}", file, e);
        }
    }

    private String estensione(String nomeOriginale) {
        if (nomeOriginale == null || !nomeOriginale.contains(".")) {
            return "";
        }
        return nomeOriginale.substring(nomeOriginale.lastIndexOf('.') + 1).toLowerCase();
    }
}