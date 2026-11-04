package it.uniroma3.siw_festival.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw_festival.exception.DuplicateFestivalException;
import it.uniroma3.siw_festival.model.Festival;
import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.repository.FestivalRepository;
import it.uniroma3.siw_festival.repository.FilmRepository;

@Service
public class FestivalService {

    private FestivalRepository festivalRepository;
    private FilmRepository filmRepository;

    private FileStorageService fileStorageService;

    public FestivalService(FestivalRepository festivalRepository, FileStorageService fileStorageService,
            FilmRepository filmRepository) {
        this.festivalRepository = festivalRepository;
        this.fileStorageService = fileStorageService;
        this.filmRepository = filmRepository;

    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Festival findByIdWithProiezioni(Long id) {
        return festivalRepository.findByIdWithProiezioni(id);
    }

    public Festival findById(Long id) {
        return festivalRepository.findById(id).get();
    }

    public List<Festival> findAll() {
        return (List<Festival>) festivalRepository.findAll();
    }

    public Long count() {
        return this.festivalRepository.count();
    }

    // salvataggio senza immagine
    @Transactional
    public Festival save(Festival festival, List<Long> filmIds) throws DuplicateFestivalException {
        controllaDuplicati(festival);
        return salva(festival, filmIds);
    }

    // salvataggio con immagine (creazione e modifica dal form)
    @Transactional
    public Festival save(Festival festival, MultipartFile file, List<Long> filmIds)
            throws DuplicateFestivalException {

        // controllo PRIMA di scrivere l'immagine sul disco: se è un duplicato, non
        // resta nessun file orfano
        controllaDuplicati(festival);

        String vecchia = null;
        if (festival.getId() != null) {
            vecchia = findById(festival.getId()).getImmagine(); // in modifica conserviamo l'immagine attuale
            festival.setImmagine(vecchia);
        }

        boolean nuovaImmagine = (file != null && !file.isEmpty());
        if (nuovaImmagine) {
            festival.setImmagine(fileStorageService.store(file, "festivals"));
        }

        Festival salvato = salva(festival, filmIds);

        // la vecchia immagine si cancella solo se ne è stata caricata una nuova (e ce
        // n'era una)
        if (nuovaImmagine && vecchia != null) {
            fileStorageService.delete(vecchia);
        }
        return salvato;
    }

    // salva il festival e poi collega i film scelti
    private Festival salva(Festival festival, List<Long> filmIds) {
        Festival salvato = festivalRepository.save(festival); // dopo questa riga il festival ha l'id
        impostaFilm(salvato, filmIds); // il metodo che ti ho dato prima, invariato
        return salvato;
    }

    // stesso controllo di prima, in un metodo solo
    private void controllaDuplicati(Festival festival) throws DuplicateFestivalException {
        boolean duplicato;
        if (festival.getId() == null) {
            // inserimento nuovo: controlla nome e anno
            duplicato = festivalRepository.existsByNomeAndAnno(festival.getNome(), festival.getAnno());
        } else {
            // aggiornamento: ignora il festival stesso
            duplicato = festivalRepository.existsByNomeAndAnnoAndIdNot(
                    festival.getNome(), festival.getAnno(), festival.getId());
        }
        if (duplicato) {
            throw new DuplicateFestivalException(festival.getNome(), festival.getAnno());
        }
    }

    @Transactional(readOnly = true)
    public List<Festival> cerca(String prefisso) {
        return festivalRepository.findTop15ByNomeStartingWithIgnoreCaseOrderByNomeAsc(prefisso.trim());
    }

    // serve per mostrare i festival già selezionati quando la pagina viene
    // ricaricata
    @Transactional(readOnly = true)
    public List<Festival> findAllById(List<Long> ids) {
        List<Festival> lista = new ArrayList<>();
        festivalRepository.findAllById(ids).forEach(lista::add);
        return lista;
    }

    // Fa in modo che i film collegati al festival siano esattamente quelli in
    // filmIds
    private void impostaFilm(Festival festival, List<Long> filmIds) {
        if (filmIds == null) {
            filmIds = new ArrayList<>();
        }

        // 1. film collegati ma non più selezionati: togli il festival
        for (Film film : filmRepository.findByFestivalsId(festival.getId())) {
            if (!filmIds.contains(film.getId())) {
                film.getFestivals().removeIf(f -> f.getId().equals(festival.getId()));
            }
        }

        // 2. film selezionati: aggiungi il festival se non c'è già
        for (Film film : filmRepository.findAllById(filmIds)) {
            boolean giaCollegato = film.getFestivals().stream()
                    .anyMatch(f -> f.getId().equals(festival.getId()));
            if (!giaCollegato) {
                film.getFestivals().add(festival);
            }
        }
    }

    @Transactional(readOnly = true)
    public Festival findRandom() {
        return festivalRepository.findRandom().orElse(null); // null se non ci sono festival
    }

}
