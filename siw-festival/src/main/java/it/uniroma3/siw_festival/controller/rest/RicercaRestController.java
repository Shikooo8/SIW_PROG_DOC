package it.uniroma3.siw_festival.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.siw_festival.model.Attore;
import it.uniroma3.siw_festival.model.Festival;
import it.uniroma3.siw_festival.service.AttoreService;
import it.uniroma3.siw_festival.service.FestivalService;

@RestController
public class RicercaRestController {

    private final FestivalService festivalService;
    private final AttoreService attoreService;

    public RicercaRestController(FestivalService festivalService, AttoreService attoreService) {
        this.festivalService = festivalService;
        this.attoreService = attoreService;
    }

    // un "record" è una classe immutabile compatta: crea da solo costruttore e getter
    public record Opzione(Long id, String label) {}

    @GetMapping("/admin/ricerca/festival")
    public List<Opzione> cercaFestival(@RequestParam(defaultValue = "") String q) {
        List<Opzione> risultato = new ArrayList<>();
        for (Festival f : festivalService.cerca(q)) {
            risultato.add(new Opzione(f.getId(), f.getNome() + " (" + f.getAnno() + ")"));
        }
        return risultato;
    }

    @GetMapping("/admin/ricerca/attori")
    public List<Opzione> cercaAttori(@RequestParam(defaultValue = "") String q) {
        List<Opzione> risultato = new ArrayList<>();
        for (Attore a : attoreService.cerca(q)) {
            risultato.add(new Opzione(a.getId(), a.getNome() + " " + a.getCognome()));
        }
        return risultato;
    }
}