package it.uniroma3.siw_festival.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import it.uniroma3.siw_festival.model.Sala;
import it.uniroma3.siw_festival.service.SalaService;

@Controller
public class SalaController {


    private SalaService salaService;

    public SalaController(SalaService salaService){
        this.salaService = salaService;
    }

    // Mostra la lista e il form di creazione vuoto
    @GetMapping("/admin/sale")
    public String manageSale(Model model) {
        model.addAttribute("sale", salaService.findAll());
        model.addAttribute("nuovaSala", new Sala());
        return "admin/sala/manage";
    }

    // Salva la nuova sala
    @PostMapping("/admin/sale")
    public String saveSala(@Valid @ModelAttribute("nuovaSala") Sala sala, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("sale", salaService.findAll());
            return "admin/sala/manage";
        }
        // Se hai una DuplicateSalaException nel service gestiscila nel catch come per il regista
        salaService.save(sala);
        return "redirect:/admin/sale";
    }

  

    // Mostra il form di modifica
    @GetMapping("/admin/sale/{id}/edit")
    public String editSalaForm(@PathVariable Long id, Model model) {
        model.addAttribute("sala", salaService.findById(id));
        return "admin/sala/edit";
    }

    // Riceve i dati aggiornati e li salva (l'ID sovrascrive il record esistente)
    @PostMapping("/admin/sale/{id}/edit")
    public String updateSala(@PathVariable Long id, @Valid @ModelAttribute("sala") Sala sala, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/sala/edit";
        }
        sala.setId(id);
        salaService.save(sala);
        return "redirect:/admin/sale";
    }
}