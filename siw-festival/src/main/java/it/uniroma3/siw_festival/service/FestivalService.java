package it.uniroma3.siw_festival.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw_festival.exception.DuplicateFestivalException;
import it.uniroma3.siw_festival.model.Festival;
import it.uniroma3.siw_festival.repository.FestivalRepository;

@Service
public class FestivalService {

    private FestivalRepository festivalRepository;

    private FileStorageService fileStorageService;

    public FestivalService(FestivalRepository festivalRepository, FileStorageService fileStorageService) {
        this.festivalRepository = festivalRepository;
        this.fileStorageService = fileStorageService;

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

    @Transactional
    public Festival save(Festival festival) throws DuplicateFestivalException {
        if (festival.getId() == null) {
            // È un inserimento nuovo: controlla tutto
            if (festivalRepository.existsByNomeAndAnno(festival.getNome(), festival.getAnno())) {
                throw new DuplicateFestivalException(festival.getNome(), festival.getAnno());
            }
        } else {
            // È un aggiornamento: ignora l'ID del festival stesso
            if (festivalRepository.existsByNomeAndAnnoAndIdNot(festival.getNome(), festival.getAnno(),
                    festival.getId())) {
                throw new DuplicateFestivalException(festival.getNome(), festival.getAnno());
            }
        }
        return festivalRepository.save(festival);
    }

    @Transactional
    public Festival save(Festival festival, MultipartFile file) throws DuplicateFestivalException {
        String vecchia = null;
        if (festival.getId() != null) {
            vecchia = findById(festival.getId()).getImmagine(); // in modifica conserviamo l'immagine attuale
            festival.setImmagine(vecchia);
        }
        if (file != null && !file.isEmpty()) {
            festival.setImmagine(fileStorageService.store(file, "festivals"));
        }
        Festival salvato = save(festival); // il tuo save con il controllo duplicati
        if (file != null && !file.isEmpty()) {
            fileStorageService.delete(vecchia);
        }
        return salvato;
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

}
