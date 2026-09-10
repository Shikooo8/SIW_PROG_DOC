package it.uniroma3.siw_festival.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw_festival.exception.DuplicateUtenteException;
import it.uniroma3.siw_festival.model.Utente;
import it.uniroma3.siw_festival.service.UtenteService;
import jakarta.validation.Valid;

@Controller 
public class AuthController {

     private UtenteService utenteService;
    
    public AuthController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }


    @GetMapping("/admin/index")
    public String adminPort(Model model) {
  
        return "/admin/index"; 
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "authentication/loginForm";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("utente", new Utente());
        return "authentication/registerForm";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("utente") Utente utente, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "authentication/registerForm";
        }
        try {
            utenteService.registra(utente);
            return "redirect:/login?registered=true";
        } catch (DuplicateUtenteException e) {
            bindingResult.reject("utente.duplicate", e.getMessage());
            return "authentication/registerForm";
        }

    }
}
