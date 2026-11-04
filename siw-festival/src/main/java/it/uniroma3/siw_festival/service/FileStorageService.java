package it.uniroma3.siw_festival.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        try {
            String estensione = rilevaEstensione(file);   // "jpg", "png" o "webp", oppure null
            if (estensione == null) {
                throw new ImmagineNonValidaException("Sono ammesse solo immagini JPG/JPEG, PNG o WEBP");
            }
            // il nome originale NON viene mai usato: evita path traversal e collisioni
            String nomeFile = UUID.randomUUID() + "." + estensione;
            Path cartella = root.resolve(sottocartella);
            Files.createDirectories(cartella);
            file.transferTo(cartella.resolve(nomeFile));
            return sottocartella + "/" + nomeFile;
        } catch (IOException e) {
            throw new UncheckedIOException("Impossibile salvare l'immagine", e);
        }
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

    /**
     * Riconosce il formato dai primi byte (magic number), ignorando nome file e Content-Type.
     * JPEG (anche .jpeg/.jfif) inizia con FF D8 FF; PNG con 89 'PNG'; WEBP con 'RIFF'....'WEBP'.
     */
    private String rilevaEstensione(MultipartFile file) throws IOException {
        byte[] h = new byte[12];
        try (InputStream in = file.getInputStream()) {
            if (in.readNBytes(h, 0, 12) < 12) {
                return null;   // file troppo corto per essere un'immagine
            }
        }
        if ((h[0] & 0xFF) == 0xFF && (h[1] & 0xFF) == 0xD8 && (h[2] & 0xFF) == 0xFF) {
            return "jpg";
        }
        if ((h[0] & 0xFF) == 0x89 && h[1] == 'P' && h[2] == 'N' && h[3] == 'G') {
            return "png";
        }
        if (h[0] == 'R' && h[1] == 'I' && h[2] == 'F' && h[3] == 'F'
                && h[8] == 'W' && h[9] == 'E' && h[10] == 'B' && h[11] == 'P') {
            return "webp";
        }
        return null;
    }
}