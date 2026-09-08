package it.uniroma3.siw_festival.controller.rest;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import it.uniroma3.siw_festival.model.Festival;
import it.uniroma3.siw_festival.service.FestivalService;

@RestController
@RequestMapping("/api/festivals")
public class FestivalRestController {

    private final FestivalService festivalService;

    public FestivalRestController(FestivalService festivalService) {
        this.festivalService = festivalService;
    }

    @GetMapping
    public List<Festival> getFestivals() {
        return festivalService.findAll();
    }

    @GetMapping("/{id}")
    public Festival getFestival(@PathVariable Long id) {
        return festivalService.findById(id);
    }
}   