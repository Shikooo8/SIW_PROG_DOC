package it.uniroma3.siw_festival.controller.rest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.siw_festival.model.Festival;
import it.uniroma3.siw_festival.service.FestivalService;

@RestController
@RequestMapping("/api/festivals")
public class FestivalRestController {

    private final FestivalService festivalService;

    public FestivalRestController(FestivalService festivalService) {
        this.festivalService = festivalService;
    }

    @GetMapping("{id}/screenings")
    public List<Map<String, Object>> getFestivalScreenings(@PathVariable Long id) {
        Festival festival = festivalService.findByIdWithProiezioni(id);
        
        // Mappiamo le proiezioni in un formato facile da leggere per React
        return festival.getProiezioni().stream().map(p -> {
            Map<String, Object> dto = new HashMap<>();
            dto.put("id", p.getId());
            dto.put("data", p.getData());
            dto.put("ora", p.getOra());
            dto.put("stato", p.getStato().name());
            dto.put("filmTitolo", p.getFilm() != null ? p.getFilm().getTitolo() : "Film rimosso");
            dto.put("salaNome", p.getSala() != null ? p.getSala().getNome() : "Sala non assegnata");
            return dto;
        }).collect(Collectors.toList());
    }
}