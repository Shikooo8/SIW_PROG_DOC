package it.uniroma3.siw_festival.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//import org.slf4j.Logger;

//import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import it.uniroma3.siw_festival.dto.FilmForm;
import it.uniroma3.siw_festival.dto.InterpretazioneForm;
import it.uniroma3.siw_festival.exception.CastNonValidoException;
import it.uniroma3.siw_festival.exception.DuplicateFilmException;
import it.uniroma3.siw_festival.exception.FilmNotFoundException;
import it.uniroma3.siw_festival.model.Attore;
import it.uniroma3.siw_festival.model.Festival;
import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.model.Interpretazione;
import it.uniroma3.siw_festival.repository.AttoreRepository;
import it.uniroma3.siw_festival.repository.FestivalRepository;
import it.uniroma3.siw_festival.repository.FilmRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilmService {

    private FilmRepository filmRepository;
    private FestivalRepository festivalRepository;
    private AttoreRepository attoreRepository;
    private FileStorageService fileStorageService;

    public FilmService(FilmRepository filmRepository, FestivalRepository festivalRepository,
            AttoreRepository attoreRepository, FileStorageService fileStorageService) {
        this.festivalRepository = festivalRepository;
        this.filmRepository = filmRepository;
        this.attoreRepository = attoreRepository;
        this.fileStorageService = fileStorageService;
    }

    // PREVEDE ERRORE 404
    @Transactional
    public Film findById(Long id) {
        Optional<Film> optionalFilm = filmRepository.findById(id);
        if (optionalFilm.isPresent()) {
            return optionalFilm.get();
        } else {
            throw new FilmNotFoundException(id);
        }
    }

    @Transactional(readOnly = true)
    public Film findByIdWithProiezioni(Long id) {
        return filmRepository.findByIdWithProiezioni(id);
    }

    public List<Film> findAll() {
        return (List<Film>) filmRepository.findAll();
    }

    public Long count() {
        return this.filmRepository.count();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE) // legge per decidere se scrivere (duplicati)
    public Film save(FilmForm form) {
        Long id = form.getId();
        boolean duplicato = (id == null)
                ? filmRepository.existsByTitoloAndAnno(form.getTitolo(), form.getAnno())
                : filmRepository.existsByTitoloAndAnnoAndIdNot(form.getTitolo(), form.getAnno(), id);
        if (duplicato) {
            throw new DuplicateFilmException(form.getTitolo(), form.getAnno());
        }

        Film film = (id == null) ? new Film() : this.findById(id);
        film.setTitolo(form.getTitolo().trim());
        film.setAnno(form.getAnno());
        film.setDurata(form.getDurata());
        film.setGenere(form.getGenere());
        film.setPaeseProduzione(form.getPaeseProduzione());
        film.setRegista(form.getRegista().trim());

        List<Festival> festivals = new ArrayList<>();
        festivalRepository.findAllById(form.getFestivalIds()).forEach(festivals::add);
        film.setFestivals(festivals);

        // cast: aggiorna le interpretazioni esistenti (per id), crea le nuove, le
        // assenti vengono rimosse
        Map<Long, Interpretazione> esistenti = new HashMap<>();
        for (Interpretazione i : film.getInterpretazioni()) {
            esistenti.put(i.getId(), i);
        }
        List<Interpretazione> nuovoCast = new ArrayList<>();
        Set<Long> attoriUsati = new HashSet<>();

        for (InterpretazioneForm riga : form.getCast()) {
            Attore attore = risolviAttore(riga);
            if (!attoriUsati.add(attore.getId())) {
                throw new CastNonValidoException(
                        attore.getNome() + " " + attore.getCognome() + " compare più volte nel cast di questo film");
            }
            Interpretazione interp = (riga.getId() != null) ? esistenti.get(riga.getId()) : null;
            if (interp == null) {
                interp = new Interpretazione();
                interp.setFilm(film);
            }
            interp.setPersonaggio(riga.getPersonaggio().trim());
            interp.setAttore(attore);
            nuovoCast.add(interp);
        }
        film.getInterpretazioni().clear(); // orphanRemoval cancella quelle non più presenti
        film.getInterpretazioni().addAll(nuovoCast);

        return filmRepository.save(film); // cascade ALL salva le interpretazioni
    }

    @Transactional
    public Film save(FilmForm form, MultipartFile file) {
        Film film = save(form); // la tua logica esistente
        if (file != null && !file.isEmpty()) {
            String vecchia = film.getImmagine();
            film.setImmagine(fileStorageService.store(file, "films"));
            film = filmRepository.save(film);
            fileStorageService.delete(vecchia); // null se era il primo caricamento
        }
        return film;
    }

    // TODO ho lasciato l'altro save, che viene usato dal festival
    @Transactional
    public Film save(Film film) throws DuplicateFilmException {
        if (film.getId() == null) {
            // Inserimento nuovo film
            if (filmRepository.existsByTitoloAndAnno(film.getTitolo(), film.getAnno())) {
                throw new DuplicateFilmException(film.getTitolo(), film.getAnno());
            }
        } else {
            // Modifica film esistente: escludi l'ID corrente dalla ricerca
            if (filmRepository.existsByTitoloAndAnnoAndIdNot(film.getTitolo(), film.getAnno(), film.getId())) {
                throw new DuplicateFilmException(film.getTitolo(), film.getAnno());
            }
        }
        return filmRepository.save(film);
    }

    private Attore risolviAttore(InterpretazioneForm riga) {

        // caso 1: attore scelto dall'elenco
        if (!riga.isNuovoAttore()) {
            if (riga.getAttoreId() == null) {
                throw new CastNonValidoException("Per il personaggio '" + riga.getPersonaggio()
                        + "' scegli un attore dall'elenco oppure spunta 'Nuovo attore'");
            }
            return attoreRepository.findById(riga.getAttoreId())
                    .orElseThrow(() -> new CastNonValidoException("Attore non trovato"));
        }

        // caso 2: nuovo attore
        String nome = riga.getNome() == null ? "" : riga.getNome().trim();
        String cognome = riga.getCognome() == null ? "" : riga.getCognome().trim();
        if (nome.isEmpty() || cognome.isEmpty()) {
            throw new CastNonValidoException("Per il personaggio '" + riga.getPersonaggio()
                    + "' inserisci nome e cognome del nuovo attore");
        }
        if (attoreRepository.existsByNomeAndCognome(nome, cognome)) {
            throw new CastNonValidoException("L'attore " + nome + " " + cognome
                    + " esiste già: toglilo da 'Nuovo attore' e cercalo nell'elenco");
        }
        Attore nuovo = new Attore();
        nuovo.setNome(nome);
        nuovo.setCognome(cognome);
        nuovo.setDataNascita(riga.getDataNascita());
        nuovo.setNazionalità(riga.getNazionalita());
        return attoreRepository.save(nuovo);
    }

    // per precompilare la form di modifica (nel service per evitare
    // LazyInitializationException)
    @Transactional(readOnly = true)
    public FilmForm getFilmForm(Long id) {
        Film film = this.findById(id);
        FilmForm form = new FilmForm();
        form.setId(film.getId());
        form.setTitolo(film.getTitolo());
        form.setAnno(film.getAnno());
        form.setDurata(film.getDurata());
        form.setGenere(film.getGenere());
        form.setPaeseProduzione(film.getPaeseProduzione());
        form.setRegista(film.getRegista());
        for (Festival f : film.getFestivals()) {
            form.getFestivalIds().add(f.getId());
        }
        for (Interpretazione i : film.getInterpretazioni()) {
            InterpretazioneForm r = new InterpretazioneForm();
            r.setId(i.getId());
            r.setPersonaggio(i.getPersonaggio());
            r.setAttoreId(i.getAttore().getId());
            r.setAttoreLabel(i.getAttore().getNome() + " " + i.getAttore().getCognome());
            form.getCast().add(r);
        }
        return form;
    }

    @Transactional(readOnly = true)
    public List<Film> cerca(String prefisso) {
        return filmRepository.findTop15ByTitoloStartingWithIgnoreCaseOrderByTitoloAsc(prefisso.trim());
    }

    @Transactional(readOnly = true)
    public List<Film> findAllById(List<Long> ids) {
        List<Film> lista = new ArrayList<>();
        filmRepository.findAllById(ids).forEach(lista::add);
        return lista;
    }

    @Transactional(readOnly = true)
    public List<Film> findByFestivalId(Long festivalId) {
        return filmRepository.findByFestivalsId(festivalId);
    }

}
