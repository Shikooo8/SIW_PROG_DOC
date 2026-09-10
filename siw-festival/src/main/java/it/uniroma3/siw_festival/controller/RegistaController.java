package it.uniroma3.siw_festival.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import it.uniroma3.siw_festival.exception.DuplicateRegistaException;
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



    @GetMapping("/regista/{id}")
    public String showRegista(@PathVariable Long id, Model model) {
        model.addAttribute("regista", registaService.findById(id));
        return "regista/show";
    }



    // Mostra la lista e il form vuoto
    @GetMapping("/admin/registi")
    public String manageRegisti(Model model) {
        model.addAttribute("registi", registaService.findAll());
        model.addAttribute("nuovoRegista", new Regista()); 
        return "admin/regista/manage"; 
    }

    // Salva il nuovo regista
    @PostMapping("/admin/registi")
    public String saveRegista(@Valid @ModelAttribute("nuovoRegista") Regista regista, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("registi", registaService.findAll());
            return "admin/regista/manage";
        }
        try {
            registaService.save(regista);
            return "redirect:/admin/registi";
        } catch (DuplicateRegistaException e) {
            bindingResult.reject("regista.duplicate");
            model.addAttribute("registi", registaService.findAll());
            return "admin/regista/manage";
        }
    }

    // Mostra il form di modifica precompilato
    @GetMapping("/admin/registi/{id}/edit")
    public String editRegistaForm(@PathVariable Long id, Model model) {
        // Presuppone che tu abbia un metodo findById nel Service che restituisca il regista
        Regista regista = registaService.findById(id); 
        model.addAttribute("regista", regista);
        return "admin/regista/edit"; 
    }

    // Riceve i dati aggiornati e li salva
    @PostMapping("/admin/registi/{id}/edit")
    public String updateRegista(@PathVariable Long id, @Valid @ModelAttribute("regista") Regista regista, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/regista/edit"; // Torna al form se ci sono errori di validazione
        }
        
        // Assicurati che l'ID sia impostato in modo che JPA esegua un UPDATE e non un INSERT[cite: 6]
        regista.setId(id);
        
        try {
            registaService.save(regista);
        } catch (DuplicateRegistaException e) {
            bindingResult.reject("regista.duplicate");
            return "admin/regista/edit";
        }
        
        return "redirect:/admin/registi";
    }
 
    
    
}
