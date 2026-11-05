package it.uniroma3.siw_festival.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw_festival.exception.DuplicateUtenteException;
import it.uniroma3.siw_festival.model.Utente;
import it.uniroma3.siw_festival.service.UtenteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AuthController {

    private UtenteService utenteService;

    public AuthController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        boolean haRichiestaSalvata = session.getAttribute("SPRING_SECURITY_SAVED_REQUEST") != null;
        String referer = request.getHeader("Referer");
        if (!haRichiestaSalvata && referer != null
                && !referer.contains("/login") && !referer.contains("/register")) {
            try {
                URI uri = new URI(referer);
                String target = uri.getPath() + (uri.getQuery() != null ? "?" + uri.getQuery() : "");
                session.setAttribute("LOGIN_REDIRECT", target); // solo path: niente open redirect
            } catch (URISyntaxException e) {
                /* ignora */ }
        }
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
