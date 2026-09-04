package it.uniroma3.siw_festival.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw_festival.model.Festival;
import it.uniroma3.siw_festival.service.FestivalService;
import jakarta.validation.Valid;

@Controller 
//@RequestMapping("/festivals")
public class FestivalController {

    private final FestivalService festivalService;

    public FestivalController(FestivalService festivalService) {
        this.festivalService = festivalService;
    }

    //#==================================pubblico#==================================

    @GetMapping ("/festival/list")
    public String list(Model model) {
        model.addAttribute("festivals", festivalService.findAll());
        return "festivals/list";
    }

    @GetMapping("/festival/{id}")
    public String show(@PathVariable Long id, Model model) {
        Festival festival = festivalService.findById(id); // lancia FestivalNotFoundException se assente
        model.addAttribute("festival", festival);
        // festival.getFilm() e festival.getProiezioni() alimentano la stessa pagina
        // (spec: "il dettaglio di un festival deve permettere di accedere ai film e alle proiezioni associate")
        return "festivals/show";
    }

    //#==================================admin#==================================
/*
@GetMapping("/new")
@PreAuthorize("hasAuthority('ADMIN')")
public String createForm(Model model) {
    model.addAttribute("festival", new Festival());
    return "festivals/form";
}

@PostMapping
@PreAuthorize("hasAuthority('ADMIN')")
public String create(@Valid @ModelAttribute("festival") Festival festival,
                      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        return "festivals/form";
    }
    Festival saved = festivalService.save(festival);
    return "redirect:/festivals/" + saved.getId();
}

@GetMapping("/{id}/edit")
@PreAuthorize("hasAuthority('ADMIN')")
public String editForm(@PathVariable Long id, Model model) {
    model.addAttribute("festival", festivalService.findById(id));
    return "festivals/form";
}

@PostMapping("/{id}")
@PreAuthorize("hasAuthority('ADMIN')")
public String update(@PathVariable Long id,
                      @Valid @ModelAttribute("festival") Festival festival,
                      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        return "festivals/form";
    }
    festival.setId(id);
    festivalService.save(festival);
    return "redirect:/festivals/" + id;
}
 */
}