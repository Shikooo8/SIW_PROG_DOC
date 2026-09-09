package it.uniroma3.siw_festival.controller;


import org.springframework.web.bind.annotation.*;

import it.uniroma3.siw_festival.model.Proiezione;
import it.uniroma3.siw_festival.service.ProiezioneService;

import java.util.List;

@RestController
@RequestMapping("/api/festivals")
public class ProiezioneRestController {
    
    private final ProiezioneService proiezioneService;

    public ProiezioneRestController(ProiezioneService proiezioneService) {
        this.proiezioneService = proiezioneService;
    }

    @GetMapping("/{id}/screenings")
    public List<Proiezione> getProiezioniByFestival(@PathVariable("id") Long id) {
        return this.proiezioneService.findProiezioniByFestivalId(id);
    }
}