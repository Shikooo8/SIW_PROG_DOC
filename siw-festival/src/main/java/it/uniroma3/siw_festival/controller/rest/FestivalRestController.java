package it.uniroma3.siw_festival.controller.rest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.siw_festival.model.Proiezione;
import it.uniroma3.siw_festival.service.FestivalService;
import it.uniroma3.siw_festival.service.ProiezioneService;

@RestController
@RequestMapping("/api/festivals")
public class FestivalRestController {

    private final FestivalService festivalService;
    private ProiezioneService proiezioneService;

    public FestivalRestController(FestivalService festivalService, ProiezioneService proiezioneService) {
        this.festivalService = festivalService;
        this.proiezioneService = proiezioneService;
    }

    @GetMapping("{id}/screenings")
    public List<Map<String, Object>> getFestivalScreenings( @PathVariable Long id,  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {

        List<Proiezione> proiezioni;
        if (data != null) {
        // filtro fatto dal database
            proiezioni = proiezioneService.findProiezioniByFestivalIdAndData(id, data);
        } else {
            proiezioni = festivalService.findByIdWithProiezioni(id).getProiezioni();
        }

        return proiezioni.stream().map(this::toDto).collect(Collectors.toList());
    }

    private Map<String, Object> toDto(Proiezione p) {
        Map<String, Object> dto = new HashMap<>();
        dto.put("id", p.getId());
        dto.put("data", p.getData());
        dto.put("ora", p.getOra());
        dto.put("stato", p.getStato().name());
        dto.put("filmTitolo", p.getFilm() != null ? p.getFilm().getTitolo() : "Film rimosso");
        dto.put("salaNome", p.getSala() != null ? p.getSala().getNome() : "Sala non assegnata");
        return dto;
    }
}