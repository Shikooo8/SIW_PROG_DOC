# Sistemi Informativi sul Web

Progetto dato dal docente per il corso di Sistemi Informativi sul Web dell'anno accademico 2025/2026

## Descrizione Progetto

Un sistema per la gestione di festival cinematografici
· ogni film ha più attori, ciascuno dei quali interpreta un personaggio (ad es. Marlon Brando nel Film il padrino interpreta il personaggio di don Vito Corleone)


### Funzionalità pubbliche (implementate!)
- visualizzazione dell’elenco dei festival
- visualizzazione del dettaglio di un festival
- visualizzazione dei film partecipanti a un festival
- visualizzazione del programma delle proiezioni (Implementato con REACT!!)
- visualizzazione del dettaglio di un film
- visualizzazione delle recensioni di un film
- Il dettaglio di un festival deve permettere di accedere ai film e alle proiezioni associate.
- Il dettaglio di un film deve mostrare almeno le informazioni sul film, il regista, i festival ai quali partecipa, le eventuali proiezioni e le recensioni.

### Funzionalità utenti registrati (implementate!!)
- inserimento di al massimo una sola recensione per utente relativa a ciascun film
- modifica di una propria recensione
- eliminazione di una propria recensione

### Funzionalità riservate all’amministratore (implementate !!!)
- creazione e modifica di un festival               
- inserimento e modifica di un film                 
- inserimento e modifica di un regista              
- associazione di un film a un festival             
- inserimento e modifica di una sala                
- programmazione di una proiezione                  
- modifica o cancellazione di una proiezione        
- eliminazione di un film da un festival 

Il sistema deve verificare la consistenza delle operazioni effettuate. Ad esempio, non deve essere possibile
programmare due proiezioni nella stessa sala nello stesso intervallo temporale.


## Errori trovati

- Gestione degli errori (proiezioni nello stesso slot temporale rimanda ad errore ma da gestire)
- Quando si inseriscono le cose il seq number è a caso


Implementato ora:

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

### `/dto`
*   **`RecensioneForm`**

### `/exception`
*   ** `DuplicateFestivalException`**
*   ** `DuplicateFilException`**
*   ** `DuplicateRecensioneException`**
*   ** `DuplicateRegistaException`**
*   ** `DuplicateSalaException`**
*   ** `DuplicateUtenteException`**
*   ** `FilmNotFoundException`**
*   ** `GlobalExceptionHandler`**
*   ** `OverlappingProiezioneException`**
*   ** `RecensioneNotFoundException`**
*   ** `RecenzioneUnauthorizedException`**

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
    *   `@GetMapping("/register")` ➔ `return "authentication/loginForm"`
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
    *   `@GetMapping("/admin/film/new")` ➔ `return "admin/film/form"`
    *   `@GetMapping("/admin/film/{id}/edit")` ➔ `return "admin/film/formEdit"`
    *   `@PostMapping("/film")` ➔ `return "redirect:/film"`


*   **`GlobalBindingConfig`**
    *   `InitBinder (WebDataBinder binder)`

*   **`GlobalController`**
    *   `@ModelAttribute("userDetails")`

*   **`HomeController`**
    *   `@GetMapping("/")` ➔ `return "index"`


*   **`ProiezioneController`**
    *   `@GetMapping("/admin/festival/{festivalId}/proiezione/new")`  ➔ `return "admin/proiezione/form"`
    *   `@PostMapping("/admin/festival/{festivalId}/proiezione/new")`  ➔ `return "admin/proiezione/form"`
    *    `@GetMapping("/admin/proiezione/{id}/delete")`  ➔ `return "redirect:/festival/" + festivalId;`
    *    `@GetMapping("/admin/proiezione/{id}/edit")`  ➔ `return "/admin/proiezione/editForm"`
    *    `@PostMapping("/admin/proiezione/{id}/edit")`  ➔ `return "redirect:/festival/" + proiezione.getFestival(),getId();`

*   **`ReactAppController`**
    *   `(...)`
      
*   **`RecensioneController`**
    *    `@GetMapping("/film/{filmId}/recensione/new")`  ➔ `return "recensione/form"`
    *    `@PostMapping("/film/{filmId}/recensione")`  ➔ `return "redirect:/film/" + filmId;`
    *    `@GetMapping("/recensione/{id}/edit")`  ➔ `return "recensione/editForm"`
    *    `@PostMapping("/recensione/{id}/edit")`  ➔ `return "redirect:/film/" + recensione.getFilm(),getId();`
    *    `@GetMapping("/recensione/{id}/delete")`  ➔ `return "redirect:/film/" + filmId;`

*   **`SalaController`**
    *   `@GetMapping("/admin/sale")` ➔ `return "admin/sale/manage"`
    *   `@PostMapping("/admin/sale")` ➔ `return "redirect:/admin/sale"`
    *   `@GetMapping("/admin/sala/{id}/edit")` ➔ `return "admin/sala/edit"`
    *   `@PostMapping("/admin/sala/{id}/edit")` ➔ `return "redirect:/admin/sale"`

*   **`UtenteRestController`**
    *   `@RequestMapping("/api")`
    *   `@GetMapping("/utente/me")`

###  `/exception`
*   **`DuplicateEventoException`**: `titolo` & `data`

###  `/model`
*   **`Festival`**: `Long id`, `String nome`, `Integer anno`, `String città`, `java.time.LocalDate dataInizio`, `java.time.LocalDate dataFine`, `String descrizione`, `@ManyToMany(mappedBy = "festivals") List<Film> film`,`@OneToMany(mappedBy = "festival") List<Proiezione> proiezioni`
*   **`Film`**: `Long id`, `String titolo`, `Integer anno`,`Integner durata`, `String genere`, `String paeseProduzione`, `@OneToMany(mappedBy = "film") List<Proiezione> proiezioni`, `@ManyToMany List<Festival> festivals`, `String regista`, `@OneToMany(mappedBy = "film") List<Recensione> recensioni`  
*   **`Proiezione`**: `Long id`, `java.time.LocalDate data`, `java.time.LocalTime ora`, `@Enumerated(EnumType.STRING) StatoProiezione stato`, `@JsonIgnore @ManyToOne Festival festival`, `@JsonIgnore @NotNull @ManyToOne Film film`,  `@JsonIgnore @NotNull @ManyToOne Sala sala`
*   **`Recensione`**: `Long id`, ` @NotBlank String testo`,
`@NotNull @Min(1)@Max(10)Integer voto`, `java.time.LocalDateTime data`, `@NotNull  @ManyToOne Film film`, `@ManyToOne Utente utente`
*   **`Attore`**: `Long id`, `String nome`, `String cognome`, `java.time.LocalDate dataNascita`, `String nazionalità`, `@ManyToMany(mappedBy = "attori") HashMap<Film, String> films`
*   **`Sala`**: `Long id`, `String nome`, `String indirizzo`, `Integer capienza`, `@OneToMany(mappedBy = "sala") List<Proiezione> proiezioni`
*   **`StatoProiezione`**: `{SCHEDULED, COMPLETED, CANCELLED}`
*   **`Utente`**: `Long id`, `String nome`, `String password`, `String ruolo`

### `/repository`
*(Tutte le interfacce estendono `CrudRepository<Modello, Long>`)*

*   **`FilmRepository`**
    *   `boolean existsByNomeAndAnno(String nome, Integer anno);`
    *   `@Query("SELECT f FROM Festival f LEFT JOIN FETCH f.proiezioni p LEFT JOIN FETCH p.film LEFT JOIN FETCH p.sala WHERE f.id = :id")`
    `Festival findByIdWithProiezioni(@Param("id") Long id);`
    *   `boolean existsByNomeAndAnnoAndIdNot(String nome, Integer anno, Long id);`

*   **`FilmRepository`**
    *   `boolean existsByTitoloAndAnno(String titolo, Integer anno)`
    *    `@Query("SELECT f FROM Film f LEFT JOIN FETCH f.proiezioni p LEFT JOIN FETCH p.festival LEFT JOIN FETCH p.sala WHERE f.id = :id")`
    `Film findByIdWithProiezioni(@Param("id") Long id);`
    *   `boolean existsByTitoloAndAnnoAndIdNot(String titolo, Integer anno, Long id);`

*   **`ProiezioneRepository`**
    *   `List<Proiezione> findBySalaIdAndData(Long salaId, LocalDate data);`
    *   `List<Proiezione> findByFestivalId(Long festivalId);`
    *   `Proiezione findBySalaAndDataAndOra(Sala sala, LocalDate data, LocalTime ora);`
    *    `List<Proiezione> findBySalaAndData(Sala sala, LocalDate data);`
*   **`RecensioneRepository`**
    
*   **`AttoreRepository`**
    *   `boolean existsByNomeAndCognome(...)`
*   **`SalaRepository`**
*   **`UtenteRepository`**
    *   `List<Utente> findByEmail(String email);`
    *   `List<Utente> findAll();`
    *   `List<Utente> findAllByOrderByCognomeAscNomeAsc();`
*   **`UtenteRichiestaRepository`**


###  `/service`
*   **`AttoreService`**
    *   `List<Notizia> getTutteLeNotizie()`
    *   `List<Notizia> getUltimeNotizie()`
    *   `Notizia save(Notizia notizia)`
    *   `void delete(Long id)`
*   **`FestivalService`**
    *   `boolean existsByUsername(String username)`
    *   `void save(Credenziali credenziali)`
    *   `Credenziali getByUsername(String username)`
*   **`FilmService`**
    *   `List<Evento> getEventiVisibili()`
    *   `List<Evento> getAll()`
    *   `List<Evento> getEventiVisibiliProssimi()`
    *   `Evento getEvento(Long id)`
    *   `Evento save(Evento evento)`
    *   `void nascondi(Long id)`
    *   `void delete(Long id)`
*   **`ProiezioneService`**
    *   `InformazioniGenerali getInformazioni()`
    *   `InformazioniGenerali save(InformazioniGenerali info)`
*   **`RecensioneService`**
    *   `List<Iniziativa> getIniziativeVisibili()`
    *   `List<Iniziativa> getIniziativeVisibiliProssime()`
    *   `List<Iniziativa> getAll()`
    *   `Iniziativa save(Iniziativa iniziativa)`
    *   `void delete(Long id)`

*   **`SalaService`**
    *   `List<UtenteRichiesta> getTutteLeRichieste()`
    *   `UtenteRichiesta save(UtenteRichiesta richiesta)`
    *   `void elimina(Long id)`
    *   `void approva(Long id)`
*   **`UtenteService`**
    *   `List<Utente> getTuttiGliUtenti()`
    *   `Utente registraUtente(Utente utente, String username, String passwordInChiaro)`
    *   `List<Utente> getTuttiDaCognome()`
    *   `void delete(Long id)`

###   `Validation`


---

##  Risorse
**Percorso:** `sito_backend/src/main/resources`

*   **`application.properties`**
*   **`import.sql`**

###  `/messages`
*   `messages.properties` ➔ `film.duplicato`

###  `/static`
*   **`/css`**
    *   `stile.css`
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
    *   `/regista`
        *   `edit.html`
        *   `manage.hmtl`
    *   `/sala`
        *
    *   `index.html`
*   **`/authentication`**
    *   `loginForm.html`
    *   `registerForm.html`
*   **`/error`**
    *   `404.html`
    *   `500.html`
*   **`/festival`**
    *   `list.html`
    *   `show.html`
*   **`/film`**
    *   `list.html`
    *   `recensioni.html`
    *   `show.html`
*   **`/fragments`**
    *   `base.html`
*   **`/film`**
    *   `list.html`
    *   `show.html`
*   **`/recensione`**
    *   `editForm.html`
    *   `form.html`
*   **`/regista`**
    *   `form.html`
    *   `show.html`











