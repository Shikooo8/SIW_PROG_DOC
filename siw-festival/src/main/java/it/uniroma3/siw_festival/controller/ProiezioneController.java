package it.uniroma3.siw_festival.controller;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw_festival.service.FestivalService;
import it.uniroma3.siw_festival.service.FilmService;
import it.uniroma3.siw_festival.service.ProiezioneService;
import it.uniroma3.siw_festival.service.SalaService;

@Controller
// @RequestMapping("/admin/proiezioni")
// @PreAuthorize("hasAuthority('ADMIN')")
public class ProiezioneController {

    private final ProiezioneService proiezioneService;
    private final FestivalService festivalService;
    private final FilmService filmService;
    private final SalaService salaService;

    public ProiezioneController(ProiezioneService proiezioneService, FestivalService festivalService, FilmService filmService, SalaService salaService) {
        this.proiezioneService = proiezioneService;
        this.festivalService = festivalService;
        this.filmService = filmService;
        this.salaService = salaService;
    }

/*

@GetMapping("/new")
public String createForm(@RequestParam Long festivalId, Model model) {
    model.addAttribute("proiezione", new Proiezione());
    model.addAttribute("festival", festivalService.findById(festivalId));
    model.addAttribute("film", filmService.findAll());
    model.addAttribute("sale", salaService.findAll());
    return "proiezioni/form";
}

@PostMapping
public String create(@Valid @ModelAttribute("proiezione") Proiezione proiezione, BindingResult bindingResult, @RequestParam Long festivalId, @RequestParam Long filmId, @RequestParam Long salaId, Model model) {
    if (bindingResult.hasErrors()) {
        model.addAttribute("festival", festivalService.findById(festivalId));
        model.addAttribute("film", filmService.findAll());
        model.addAttribute("sale", salaService.findAll());
        return "proiezioni/form";
    }
    try {
        proiezioneService.save(proiezione, festivalId, filmId, salaId);
    } catch (SalaOccupataException e) {
        bindingResult.reject("proiezione.salaOccupata", e.getMessage());
        model.addAttribute("festival", festivalService.findById(festivalId));
        model.addAttribute("film", filmService.findAll());
        model.addAttribute("sale", salaService.findAll());
        return "proiezioni/form";
    }
    return "redirect:/festivals/" + festivalId;
}

@PostMapping("/{id}/edit")
public String update(@PathVariable Long id, @Valid @ModelAttribute("proiezione") Proiezione proiezione,
        BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        return "proiezioni/form";
    }
    try {
        proiezioneService.update(id, proiezione);
    } catch (SalaOccupataException e) {
        bindingResult.reject("proiezione.salaOccupata", e.getMessage());
        return "proiezioni/form";
    }
    return "redirect:/festivals/" + proiezione.getFestival().getId();
}
*/

    /*
     * @DeleteMapping("/{id}")
     * public String delete(@PathVariable Long id) {
     * Long festivalId = proiezioneService.findById(id).getFestival().getId();
     * proiezioneService.delete(id);
     * return "redirect:/festivals/" + festivalId;
     * }
     * 
     */
}
