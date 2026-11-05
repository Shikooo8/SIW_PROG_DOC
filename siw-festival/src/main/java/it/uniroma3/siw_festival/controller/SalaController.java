package it.uniroma3.siw_festival.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import it.uniroma3.siw_festival.exception.DuplicateSalaException;
import it.uniroma3.siw_festival.exception.SalaInUsoException;
import it.uniroma3.siw_festival.model.Sala;
import it.uniroma3.siw_festival.service.SalaService;

@Controller
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    // Lista sale
    @GetMapping("/admin/sale")
    public String manageSale(Model model) {
        model.addAttribute("sale", salaService.findAll());
        return "admin/sala/manage";
    }

    // Form di creazione
    @GetMapping("/admin/sala/new")
    public String newSalaForm(Model model) {
        model.addAttribute("sala", new Sala());
        model.addAttribute("formAction", "/admin/sala/new");
        return "admin/sala/form";
    }

    @PostMapping("/admin/sala/new")
    public String createSala(@Valid @ModelAttribute("sala") Sala sala,
            BindingResult bindingResult, Model model) {
        model.addAttribute("formAction", "/admin/sala/new");
        if (bindingResult.hasErrors()) {
            return "admin/sala/form";
        }
        try {
            salaService.save(sala);
        } catch (DuplicateSalaException e) {
            bindingResult.rejectValue("nome", "sala.duplicate", "Esiste già una sala con questo nome");
            return "admin/sala/form";
        }
        return "redirect:/admin/sale";
    }

    // Form di modifica (stesso template della creazione)
    @GetMapping("/admin/sala/{id}/edit")
    public String editSalaForm(@PathVariable Long id, Model model) {
        model.addAttribute("sala", salaService.findById(id));
        model.addAttribute("formAction", "/admin/sala/" + id + "/edit");
        return "admin/sala/form";
    }

    @PostMapping("/admin/sala/{id}/edit")
    public String updateSala(@PathVariable Long id,
            @Valid @ModelAttribute("sala") Sala sala,
            BindingResult bindingResult, Model model) {
        model.addAttribute("formAction", "/admin/sala/" + id + "/edit");
        if (bindingResult.hasErrors()) {
            return "admin/sala/form";
        }
        sala.setId(id);
        try {
            salaService.save(sala);
        } catch (DuplicateSalaException e) {
            bindingResult.rejectValue("nome", "sala.duplicate", "Esiste già una sala con questo nome");
            return "admin/sala/form";
        }
        return "redirect:/admin/sale";
    }

    // Elimina (solo se non ci sono proiezioni)
    @PostMapping("/admin/sala/{id}/delete")
    public String deleteSala(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            salaService.deleteById(id);
        } catch (SalaInUsoException e) {
            redirectAttributes.addFlashAttribute("errore", e.getMessage());
        }
        return "redirect:/admin/sale";
    }
}