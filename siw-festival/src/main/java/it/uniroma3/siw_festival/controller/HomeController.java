package it.uniroma3.siw_festival.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    //@Autowired MovieService movieService;
   
    @GetMapping("/")
    public String getHome(Model model){
        return "index";  //nome del componente HTML che mostrerà con placeholder
    }


    
}
