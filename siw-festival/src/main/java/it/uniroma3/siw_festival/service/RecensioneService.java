package it.uniroma3.siw_festival.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw_festival.exception.DuplicateRecensioneException;
import it.uniroma3.siw_festival.exception.RecensioneNotFoundException;
import it.uniroma3.siw_festival.exception.RecensioneUnauthorizedException;
import it.uniroma3.siw_festival.model.Film;
import it.uniroma3.siw_festival.model.Recensione;
import it.uniroma3.siw_festival.model.Utente;
import it.uniroma3.siw_festival.repository.RecensioneRepository;
import it.uniroma3.siw_festival.repository.UtenteRepository;

@Service
public class RecensioneService {

    private RecensioneRepository recensioneRepository;
    private UtenteRepository utenteRepository;

    public RecensioneService(RecensioneRepository recensioneRepository, UtenteRepository utenteRepository) {
        this.recensioneRepository = recensioneRepository;
        this.utenteRepository = utenteRepository;
    }

    @Transactional(readOnly = true)
    public Recensione findById(Long id) {
        return recensioneRepository.findById(id)
                .orElseThrow(() -> new RecensioneNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<Recensione> findAll() {
        return (List<Recensione>) recensioneRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Recensione> findByFilmId(Long filmId) {
        return recensioneRepository.findByFilmId(filmId);
    }

    @Transactional(readOnly = true)
    public Long count() {
        return this.recensioneRepository.count();
    }

    @Transactional
    public Recensione save(Recensione recensione) throws DuplicateRecensioneException {
        Film film = recensione.getFilm();

        if (recensioneRepository.existsByFilmTitoloAndFilmAnnoAndUtenteUsername(
                film.getTitolo(), film.getAnno(), recensione.getUtente().getUsername())) {
            throw new DuplicateRecensioneException(film.getTitolo(), film.getAnno(),
                    recensione.getUtente().getUsername());
        }
        return recensioneRepository.save(recensione);
    }

    @Transactional
    public Recensione update(Long id, String testo, Integer voto, String username) {
        Recensione recensione = this.findById(id);
        verificaProprietario(recensione, username);

        recensione.setTesto(testo);
        recensione.setVoto(voto);
        // dirty checking: non serve richiamare save()
        return recensione;
    }

    @Transactional
    public void delete(Long id, String username) {
        Recensione recensione = this.findById(id);
        verificaProprietario(recensione, username);
        recensioneRepository.delete(recensione);
    }

    private void verificaProprietario(Recensione recensione, String username) {
        if (!recensione.getUtente().getUsername().equals(username)) {
            throw new RecensioneUnauthorizedException();
        }
    }

    public Utente getUtenteByUsername(String username) {
        return utenteRepository.findByUsername(username)
                .orElseThrow(() -> new RecensioneUnauthorizedException());

    }

    @Transactional(readOnly = true)
    public Recensione findByFilmIdAndUsername(Long filmId, String username) {
        return recensioneRepository.findByFilmIdAndUsername(filmId, username).orElse(null);
    }
}