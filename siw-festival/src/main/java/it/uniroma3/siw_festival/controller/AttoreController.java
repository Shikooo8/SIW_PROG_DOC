package it.uniroma3.siw_festival.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import it.uniroma3.siw_festival.exception.DuplicateAttoreException;
import it.uniroma3.siw_festival.model.Attore;
import it.uniroma3.siw_festival.service.AttoreService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller 
public class AttoreController {

    private AttoreService attoreService;

    public AttoreController(AttoreService attoreService){
        this.attoreService = attoreService;
    }

    @GetMapping("attori")
    public String list(Model model) {
        List<Attore> attoriList = attoreService.findAll();
        model.addAttribute("attori", attoriList);
        model.addAttribute("attoriNumber", attoriList.size());
        return "attore/list";
    }

    @GetMapping("/attore/{id}")
    public String showAttore(@PathVariable Long id, Model model) {
        model.addAttribute("attore", attoreService.findById(id));
        return "attore/show";
    }

    // Mostra la lista e il form vuoto
    @GetMapping("/admin/attori")
    public String manageAttori(Model model) {
        model.addAttribute("attori", attoreService.findAll());
        model.addAttribute("nuovoAttore", new Attore()); 
        return "admin/attore/manage"; 
    }

    // Salva il nuovo attore
    @PostMapping("/admin/attori")
    public String saveAttore(@Valid @ModelAttribute("nuovoAttore") Attore attore, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("attori", attoreService.findAll());
            return "admin/attore/manage";
        }
        try {
            attoreService.save(attore);
            return "redirect:/admin/attori";
        } catch (DuplicateAttoreException e) {
            bindingResult.reject("attore.duplicate");
            model.addAttribute("attori", attoreService.findAll());
            return "admin/attore/manage";
        }
    }

    // Mostra il form di modifica precompilato
    @GetMapping("/admin/attori/{id}/edit")
    public String editAttoreForm(@PathVariable Long id, Model model) {
        // Presuppone che tu abbia un metodo findById nel Service che restituisca il attore
        Attore attore = attoreService.findById(id); 
        model.addAttribute("attore", attore);
        return "admin/attoreEdit"; 
    }

    // Riceve i dati aggiornati e li salva
    @PostMapping("/admin/attori/{id}/edit")
    public String updateAttore(@PathVariable Long id, @Valid @ModelAttribute("attore") Attore attore, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/attoreEdit"; // Torna al form se ci sono errori di validazione
        }
        
        // Assicurati che l'ID sia impostato in modo che JPA esegua un UPDATE e non un INSERT[cite: 6]
        attore.setId(id);
        
        try {
            attoreService.save(attore);
        } catch (DuplicateAttoreException e) {
            bindingResult.reject("attore.duplicate");
            return "admin/attoreEdit";
        }
        
        return "redirect:/admin/attori";
    }
 
    
    
}
