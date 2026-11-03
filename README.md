# Sistemi Informativi sul Web

Progetto dato dal docente per il corso di Sistemi Informativi sul Web per la sessione Novembre 2026

## Descrizione Progetto


Il sistema gestisce uno o più festival cinematografici. Per ogni festival vengono registrati i film partecipanti, gli attori, le sale cinematografiche e le proiezioni programmate.

I film possono partecipare a uno o più festival e, nell’ambito di ciascun festival, possono essere presentati attraverso una o più proiezioni.

Il sistema distingue tra utenti generici, utenti registrati e utenti amministratori. Gli utenti registrati possono inserire recensioni relative ai film, mentre gli amministratori possono accedere alle funzionalità di gestione del festival.

Le funzionalità delle proiezioni sono gestite da REACT


### Funzionalità pubbliche (da controllare)
- visualizzazione dell’elenco dei festival
- visualizzazione del dettaglio di un festival
- visualizzazione dei film partecipanti a un festival
- visualizzazione del programma delle proiezioni (Implementato con REACT!!)
- visualizzazione del dettaglio di un film
- visualizzazione delle recensioni di un film
- Il dettaglio di un festival deve permettere di accedere ai film e alle proiezioni associate.
- Il dettaglio di un film deve mostrare almeno le informazioni sul film, il regista, i festival ai quali partecipa, le eventuali proiezioni e le recensioni.

### Funzionalità utenti registrati (da controllare)
- inserimento di al massimo una sola recensione per utente relativa a ciascun film
- modifica di una propria recensione
- eliminazione di una propria recensione

### Funzionalità riservate all’amministratore (da controllare )
- creazione e modifica di un festival               
- inserimento e modifica di un film                 
- inserimento e modifica di un di un attore (DA FARE)       
- associazione di un film a un festival             
- inserimento e modifica di una sala                
- programmazione di una proiezione                  
- modifica o cancellazione di una proiezione        
- eliminazione di un film da un festival 
Il sistema deve verificare la consistenza delle operazioni effettuate. Ad esempio, non deve essere possibile
programmare due proiezioni nella stessa sala nello stesso intervallo temporale.

### Funzionalità nuove (da implementare e controllare)
- ogni film ha più attori, ciascuno dei quali interpreta un personaggio (ad es. Marlon Brando nel Film il padrino interpreta il personaggio di don Vito Corleone)
- un attore può aver recitato in più film, in ogni film interpreta un personaggio

Quando viene modificato e creato un film, il regista sarà una semplice stringa, mentre per le interpretazioni ci sarà un "aggiungi nuovo personaggio", come stringa, a cui va associato un attore fra quelli del sistema oppure uno nuovo.

### Obiettivi finali

- paginazione
- ricerca e filtri
- ricerca dei film per titolo o genere 
- ricerca delle proiezioni per data
- upload di locandine o immagini
- statistiche sulle recensioni
- documentazione delle API REST
- autenticazione con OAuth
- deployment su una piattaforma cloud
Cerchiamo di mantenere tutto con un codice non troppo complesso e leggibile.

### Stile
Lo stile è molto importante, infatti serve dare al progetto una forma moderna.
- Assegnare una palette fissa e utillizzare un unico CSS con tutte le classi grafiche
- Aggiungere le immagini per Film e Festival

## Errori trovati
- Da gestire meglio le associazioni in creazione e modifica : ovvero mostrare l'intero elenco di attori e o film o festival non è efficiente, bisogna caricarne in parte e fare in modo che possano aumentare oppure il filtro per nome
- Nella modifica/creazione di un film i campi per un nuovo attore devono essere visibili solo con la scelta nuovo attore
- La modifica di proiezioni non trovata
- Gestione degli errori (proiezioni nello stesso slot temporale rimanda ad errore ma da gestire)
- Quando si inseriscono le cose il seq number è a caso
- Nella creazione del film c'è stato un errore ma non replicabile


# Struttura del Progetto

## ☕ Sorgenti Java
**Percorso:** `siw_festival/src/main/java/it/uniroma3/siw_festival`

### `/authentication`
*   **`CsrfCookieFilter`**
    *    `protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException`
*   **`SecurityConfiguration`**
    *   `UserDetailsService`
    *   `PasswordEncoder`
    *   `SecurityFilterChain`

### `/config`
*   **`CorsConfig`**
    *   `addCorsMappings(CorsRegistry registry)`
*   **`OpenApiConfig`**
    *   `OpenAPI openAPI()`

### `/controller`
*   **`/rest`**
*   **`FestivalRestController`**
    *   `@RequestMapping("/api/festivals")`
    *   `@GetMapping("{id}/screenings")`
*   **  **`FilmRestController`**
    *   `@RequestMapping("/api/films")`
    *   `@GetMapping("{id}/screenings")`
*   **  **`AttoreController`**

*   **  **`AuthController`**
    *   `@GetMapping("/admin/index")` ➔ `return "/admin/index"`
    *   `@GetMapping("/login")` ➔ `return "authentication/loginForm"`
    *   `@GetMapping("/register")` ➔ `return "authentication/registerForm"`
    *   `@PostMapping("/register")` ➔ ` return "redirect:/login?registered=true"`

*   **`FestivalController`**
    *   `@GetMapping("/festival")` ➔ `return "festival/list"`
    *   `@GetMapping("/festival/{id}")` ➔ `return "festival/show"`
    *   `@GetMapping("/admin/festival/new")` ➔ `return "admin/festival/form"`
    *   `@PostMapping("/admin/festival/new")` ➔ `return "redirect:/festival"`
    *   `@GetMapping("/admin/festival/{id}/edit")` ➔ `return "admin/festival/formEdit"`
    *   `@PostMapping("/admin/festival/{id}/edit")` ➔ `return "redirect:/festival"`

*   **`FilmController`**
    *   `@GetMapping("/film")` ➔ `return "film/list"`
    *   `@GetMapping("/film/{id}")` ➔ `return "film/show"`
    *   `@GetMapping("/film/{id}/recensioni")` ➔ `return "film/recensioni";`
    *   `String formView(Model model)`  ➔ `return "admin/film/form";`
    *   `@GetMapping("/admin/film/new")`  ➔ `return formView(model);`
    *   `@GetMapping("/admin/film/{id}/edit")`  ➔ `return formView(model);`
    *   `@PostMapping("/admin/film/cast/add")String addCast`  ➔ `return formView(model);`
    *   `@PostMapping("/admin/film/{index}/remove") String removeCast`  ➔ `return formView(model);`
    *   `@PostMapping("/admin/film")String save`  ➔ `return "redirect:/film/" + salvato.getId();`
  
*   **`GlobalBindingConfig`**
    *   `InitBinder (WebDataBinder binder)`

*   **`GlobalController`**
    *   `@ModelAttribute("userDetails")`

*   **`HomeController`**
    *   `@GetMapping("/")` ➔ `return "index"`


*   **`ProiezioneController`**
    *   `@GetMapping("/admin/festival/{festivalId}/proiezione/new")`  ➔ `return "admin/proiezione/form"`
    *   `@PostMapping("/admin/festival/{festivalId}/proiezione/new")`  ➔ `return "admin/proiezione/form"`
    *   `@GetMapping("/admin/proiezione/{id}/edit")`  ➔ `return "/admin/proiezione/editForm"`
    *   `@PostMapping("/admin/proiezione/{id}/edit")`  ➔ `return "redirect:/festival/" + proiezione.getFestival(),getId();`
    *   `@PostMapping("/admin/proiezione/{id}/delete")`  ➔ `return "redirect:/festival/" + festivalId;`

*   **`ReactAppController`**
    *   `(...)`
      
*   **`RecensioneController`**
    *    `@GetMapping("/film/{filmId}/recensione/new")`  ➔ `return "recensione/form"`
    *    `@PostMapping("/film/{filmId}/recensione")`  ➔ `return "redirect:/film/" + filmId;`
    *    `@GetMapping("/recensione/{id}/edit")`  ➔ `return "recensione/editForm"`
    *    `@PostMapping("/recensione/{id}/edit")`  ➔ `return "redirect:/film/" + recensione.getFilm(),getId();`
    *    `@PostMapping("/recensione/{id}/delete")`  ➔ `return "redirect:/film/" + filmId;`

*   **`SalaController`**
    *   `@GetMapping("/admin/sale")` ➔ `return "admin/sale/manage"`
    *   `@PostMapping("/admin/sale")` ➔ `return "redirect:/admin/sale"`
    *   `@GetMapping("/admin/sala/{id}/edit")` ➔ `return "admin/sala/edit"`
    *   `@PostMapping("/admin/sala/{id}/edit")` ➔ `return "redirect:/admin/sale"`

*   **`UtenteRestController`**
    *   `@RequestMapping("/api")`
    *   `@GetMapping("/utente/me")`

### `/dto`
*   **`RecensioneForm`**
*   **`FilmForm`**
*   **`RecensioneForm`**

### `/exception`
*   **`CastNonValidoException`**
*   **`DuplicateAttoreException`**
*   **`DuplicateFestivalException`**
*   **`DuplicateFilmException`**
*   **`DuplicateRecensioneException`**
*   **`DuplicateSalaException`**
*   **`DuplicateUtenteException`**
*   **`FilmNotFoundException`**
*   **`GlobalExceptionHandler`**
*   **`OverlappingProiezioneException`**
*   **`RecensioneNotFoundException`**
*   **`RecenzioneUnauthorizedException`**


###  `/model`
*   **`Attore`**: `Long id`, `String nome`, `String cognome`, `java.time.LocalDate dataNascita`, `String nazionalità`, `@JsonIgnore @OneToMany(mappedBy = "attore") List<Interpretazione> interpretazioni;`
*   **`Festival`**: `Long id`, `String nome`, `Integer anno`, `String città`, `java.time.LocalDate dataInizio`, `java.time.LocalDate dataFine`, `String descrizione`, `@ManyToMany(mappedBy = "festivals") List<Film> film`,`@OneToMany(mappedBy = "festival") List<Proiezione> proiezioni`
*   **`Film`**: `Long id`, `String titolo`, `Integer anno`,`Integner durata`, `String genere`, `String paeseProduzione`, `@OneToMany(mappedBy = "film") List<Proiezione> proiezioni`, `@ManyToMany List<Festival> festivals`, `String regista`, `@OneToMany(mappedBy = "film") List<Recensione> recensioni`, `@OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)List<Interpretazione> interpretazioni;`
*   **`Interpretazione`**: `Long id`, `@ManyToOne(optional = false) Attore attore;`, `    @JsonIgnore@ManyToOne(optional = false) Film film;`,  `@NotBlank String personaggio;`     
*   **`Proiezione`**: `Long id`, `java.time.LocalDate data`, `java.time.LocalTime ora`, `@Enumerated(EnumType.STRING) StatoProiezione stato`, `@JsonIgnore @ManyToOne Festival festival`, `@JsonIgnore @NotNull @ManyToOne Film film`,  `@JsonIgnore @NotNull @ManyToOne Sala sala`
*   **`Recensione`**: `Long id`, ` @NotBlank String testo`,
`@NotNull @Min(1)@Max(10)Integer voto`, `java.time.LocalDateTime data`, `@NotNull  @ManyToOne Film film`, `@ManyToOne Utente utente`
*   **`Sala`**: `Long id`, `String nome`, `String indirizzo`, `Integer capienza`, `@OneToMany(mappedBy = "sala") List<Proiezione> proiezioni`
*   **`StatoProiezione`**: `{SCHEDULED, COMPLETED, CANCELLED}`
*   **`Utente`**: `Long id`, `String username`, `String password`, `String ruolo`

### `/repository`
*(Tutte le interfacce estendono `CrudRepository<Modello, Long>`)*

*   **`AttoreRepository`**
    *   `boolean existsByNomeAndCognome(...)`

*   **`FestivalRepository`**
    *   `boolean existsByNomeAndAnno(String nome, Integer anno);`
    *   `@Query("SELECT f FROM Festival f LEFT JOIN FETCH f.proiezioni p LEFT JOIN FETCH p.film LEFT JOIN FETCH p.sala WHERE f.id = :id")`
    `Festival findByIdWithProiezioni(@Param("id") Long id);`
    *   `boolean existsByNomeAndAnnoAndIdNot(String nome, Integer anno, Long id);`

*   **`FilmRepository`**
    *   `boolean existsByTitoloAndAnno(String titolo, Integer anno)`
    *    `@Query("SELECT f FROM Film f LEFT JOIN FETCH f.proiezioni p LEFT JOIN FETCH p.festival LEFT JOIN FETCH p.sala WHERE f.id = :id")`
    *    `@Query("SELECT f FROM Film f LEFT JOIN FETCH f.interpretazioni i LEFT JOIN FETCH i.attore WHERE f.id = :id")Film findByIdWithCast(@Param("id") Long id);`
    `Film findByIdWithProiezioni(@Param("id") Long id);`
    *   `boolean existsByTitoloAndAnnoAndIdNot(String titolo, Integer anno, Long id);`

*   **`ProiezioneRepository`**
    *   `List<Proiezione> findBySalaIdAndData(Long salaId, LocalDate data);`
    *   `List<Proiezione> findByFestivalId(Long festivalId);`
    *   `Proiezione findBySalaAndDataAndOra(Sala sala, LocalDate data, LocalTime ora);`
    *    `List<Proiezione> findBySalaAndData(Sala sala, LocalDate data);`

*   **`RecensioneRepository`**
    
*   **`SalaRepository`**

*   **`UtenteRepository`**
    *   `boolean existsByUsername(String username);`
    *   `Optional<Utente> findByUsername(String username);`


###  `/service`
*   **`AttoreService`**
    *   `Attore findById(Long id)`
    *   `List<Attore> findAll()`
    *   `Attore save(Attore attore)`
    *   `void deleteById(Long id)`

*   **`FestivalService`**
    *   `Festival findById(Long id)`
    *   `Festival findByIdWithProiezioni(Long id)`
    *   `List<Festival> findAll`
    *   `Festival save(Festival film) throws DuplicateFestivalException`
    *   `Long count()`

*   **`FilmService`**
    *   `Film findById(Long id)`
    *   `Film findByIdWithProiezioni(Long id)`
    *   `List<Film> findAll`
    *   `Long count()`
    *   `Film save(FilmForm film)`
    *   `Film save(Film film) throws DuplicateFilmException`
    *   `Attore risolviAttore(InterpretazioneForm)`
    *   `FilmForm getFilmForm(Long id)`

*   **`ProiezioneService`**
    *   `Proiezione findById(Long id)`
    *   `List<Proiezione> findAl`
    *   `List<Proiezione> findProiezioniByFestivalId(Long id)`
    *   `void delete(Proiezione proiezione)`
    *   `void deleteId(Long id)`
    *   `Proiezione save(Proiezione nuovaProiezione) throws OverlappingProiezioneException`    

*   **`RecensioneService`**
    *   `Recensione findById(Long id)`
    *   `List<Recensione> findAll()`
    *   `List<Recensione> findByFilmId(Long filmId)`
    *   `Long count()`
    *   `Recensione save(Recensione recensione) throws DuplicateRecensioneException`
    *   `Recensione update(Long id, String testo, Integer voto, String username)`
    *   `void delete(Long id, String username)`
    *   `void verificaProprietario(Recensione recensione, String username)`
    *   `Utente getUtenteByUsername(String username)`
    *   `Recensione findByFilmIdAndUsername(Long filmId, String username)`


*   **`SalaService`**
    *   `Sala findById(Long id)`
    *   `List<Sala> findAll ()`
    *   `Sala save(Sala sala)`
    *   `void deleteById(Long id)`

*   **`UtenteService`**
    *   `Utente registra(Utente utente)`
    *   `Utente getUtente(Long id) (TODO)`


###   `Validation`


---

##  Risorse
**Percorso:** `sito_backend/src/main/resources`

*   **`application.properties`**
*   **`import.sql`**

###  `/messages`
*   `messages.properties` ➔ `film.duplicate`,`film.duplicato`, `NotBlank`, `NotNull`, `typeMismatch`, `typeMismatch.java.lang.Integer`, `NotBlank.film.titolo`, `Min.anno`, `festival.duplicate`
###  `/static`
*   **`/css`**
    *   `stile.css` (nuovo)
    *   `style.css`
*   **`/images`**
*   **`/react`**

###  `/templates`
*   `index.html`
*   **`/admin`**
    *   `/festival`
        *   `form.html`
        *   `formEdit.html`
    *   `/film`
        *   `form.html`
        *   `formEdit.html`
    *   `/proiezione`
        *   `form.html`
        *   `formEdit.html`
    *   `/sala`
        *
    *   `index.html` (aggiornato)
*   **`/authentication`**
    *   `loginForm.html` (aggiornato)
    *   `registerForm.html` (aggiornato)
*   **`/error`**
    *   `404.html`
    *   `500.html`
*   **`/festival`**
    *   `list.html` (aggiornato)
    *   `show.html` (aggiornato)
*   **`/film`**
    *   `list.html` (aggiornato)
    *   `recensioni.html`
    *   `show.html` (aggiornato)
*   **`/fragments`**
    *   `base.html` (aggiornato)    
*   **`/recensione`**
    *   `editForm.html` (aggiornato)
    *   `form.html` (aggiornato)

