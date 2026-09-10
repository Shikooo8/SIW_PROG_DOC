package it.uniroma3.siw_festival.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import it.uniroma3.siw_festival.model.Regista;
import it.uniroma3.siw_festival.service.RegistaService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;






@Controller 
public class RegistaController {

    private RegistaService registaService;

    public RegistaController(RegistaService registaService){
        this.registaService = registaService;
    }

    @GetMapping("registi")
    public String lsit(Model model) {
        List<Regista> registiList = registaService.findAll();
        model.addAttribute("registi", registiList);
        model.addAttribute("registiNumber", registiList.size());
        return "regista/list";
    }

    @PostMapping("/regista")
    public String save(@Valid @ModelAttribute ("regista") Regista regista, BindingResult bindingResult, Model model) {
        
        //TODO: process POST request
        
        return "redirect:/registi";
    }

    @GetMapping("/regista/{id}")
    public String showRegista(@PathVariable Long id, Model model) {
        model.addAttribute("regista", registaService.findById(id));
        return "regista/show";
    }
    
    
    
}
