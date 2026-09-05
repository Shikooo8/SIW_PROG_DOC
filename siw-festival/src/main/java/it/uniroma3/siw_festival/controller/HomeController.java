package it.uniroma3.siw_festival.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw_festival.service.FestivalService;
import it.uniroma3.siw_festival.service.FilmService;
import it.uniroma3.siw_festival.service.RegistaService;

@Controller
public class HomeController {
    // @Autowired MovieService movieService;

    private FilmService filmService;
    private FestivalService festivalService;

    public HomeController(FilmService filmService, FestivalService festivalService) {
        this.filmService = filmService;
        this.festivalService = festivalService;
    }

    @GetMapping("/")
    public String getHome(Model model) {
        Long filmNumber = this.filmService.count();                         //qui si usa COUNT sul service, non la lista!!!!!!!!!!!!
        Long festivalNumber = this.festivalService.count();
        model.addAttribute("filmFNumber", filmNumber);
        model.addAttribute("festisvalNUmber", festivalNumber);

        return "index"; // nome del componente HTML che mostrerà con placeholder
    }

}
