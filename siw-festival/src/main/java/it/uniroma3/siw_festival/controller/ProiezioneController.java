    package it.uniroma3.siw_festival.controller;

    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.validation.BindingResult;
    import org.springframework.web.bind.annotation.*;
    import jakarta.validation.Valid;
    import it.uniroma3.siw_festival.exception.OverlappingProiezioneException;
    import it.uniroma3.siw_festival.model.Proiezione;
    import it.uniroma3.siw_festival.service.FestivalService;
    import it.uniroma3.siw_festival.service.FilmService;
    import it.uniroma3.siw_festival.service.SalaService;
    import it.uniroma3.siw_festival.service.ProiezioneService;

    @Controller
    @RequestMapping("/admin/festival/{festivalId}/proiezione")
    public class ProiezioneController {

        private ProiezioneService proiezioneService;
        private FestivalService festivalService;
        private FilmService filmService;
        private SalaService salaService;

        public ProiezioneController(ProiezioneService proiezioneService, FestivalService festivalService,
                FilmService filmService, SalaService salaService) {
            this.proiezioneService = proiezioneService;
            this.festivalService = festivalService;
            this.filmService = filmService;
            this.salaService = salaService;
        }

        @GetMapping("/new")
        public String formNewProiezione(@PathVariable Long festivalId, Model model) {
            Proiezione proiezione = new Proiezione();
            // Il festival viene impostato implicitamente dall'URL, non serve sceglierlo
            // nella form
            model.addAttribute("proiezione", proiezione);
            model.addAttribute("festivalId", festivalId);

            // Carica i dati per le select
            model.addAttribute("films", filmService.findAll());
            model.addAttribute("sale", salaService.findAll());

            return "admin/proiezione/form";
        }

        @PostMapping("/new")
        public String saveProiezione(@PathVariable Long festivalId,
                @Valid @ModelAttribute("proiezione") Proiezione proiezione,
                BindingResult bindingResult,
                Model model) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("festivalId", festivalId);
                model.addAttribute("films", filmService.findAll());
                model.addAttribute("sale", salaService.findAll());
                return "admin/proiezione/form";
            }

            // Associa la proiezione al festival in cui ci troviamo
            proiezione.setFestival(festivalService.findById(festivalId));
            proiezioneService.save(proiezione);

            // Torna alla pagina del festival
            return "redirect:/festival/" + festivalId;
        }


        @GetMapping("/admin/proiezione/{id}/delete")
    public String deleteProiezione(@PathVariable Long id) {
        // 1. Recupera la proiezione
        Proiezione proiezione = proiezioneService.findById(id);
        
        // 2. Salva l'ID del festival per poterci tornare dopo
        Long festivalId = proiezione.getFestival().getId(); 
        
        // 3. Elimina
        proiezioneService.deleteId(proiezione.getId());
        
        // 4. Redirect alla pagina del festival
        return "redirect:/festival/" + festivalId; 
    }

        @GetMapping("/admin/proiezione/{id}/edit")
        public String editProiezioneForm(@PathVariable Long id, Model model) {
            // Recupera la proiezione esistente dal DB
            Proiezione proiezione = proiezioneService.findById(id);

            model.addAttribute("proiezione", proiezione);
            model.addAttribute("films", filmService.findAll());
            model.addAttribute("sale", salaService.findAll());

            // Ritorna il percorso esatto da te richiesto
            return "admin/proiezione/formEdit";
        }

        @PostMapping("/admin/proiezione/{id}/edit")
        public String updateProiezione(@PathVariable Long id,
                @Valid @ModelAttribute("proiezione") Proiezione proiezione,
                BindingResult bindingResult,
                Model model) {

            // 1. Forza l'ID per garantire la modifica della proiezione esistente[cite: 5]
            proiezione.setId(id);

            if (bindingResult.hasErrors()) {
                model.addAttribute("films", filmService.findAll());
                model.addAttribute("sale", salaService.findAll());
                return "admin/proiezione/formEdit";
            }

            try {
                // 2. Recupera il festival originale dal DB per non perderlo durante
                // l'aggiornamento
                Proiezione proiezioneEsistente = proiezioneService.findById(id);
                proiezione.setFestival(proiezioneEsistente.getFestival());

                // 3. Salva le modifiche. L'eccezione viene lanciata dal Service se c'è
                // sovrapposizione.
                proiezioneService.save(proiezione);

                return "redirect:/festival/" + proiezione.getFestival().getId();

            } catch (OverlappingProiezioneException e) {
                // Se scatta l'eccezione, il salvataggio si blocca e si torna alla form con
                // l'errore
                bindingResult.reject("proiezione.overlapping", "La sala è già occupata in questa data e fascia oraria.");
                model.addAttribute("films", filmService.findAll());
                model.addAttribute("sale", salaService.findAll());
                return "admin/proiezione/formEdit";
            }
        }
    }