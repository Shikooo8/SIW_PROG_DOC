package it.uniroma3.siw_festival.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity 
@Table (uniqueConstraints = @UniqueConstraint(columnNames = {"film_id", "utente_id"}))
public class Recensione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    

    private String testo;
    
    @NotNull
    @Min(1)
    @Max(10)
    private Integer voto;
    private java.time.LocalDateTime data;

    @ManyToOne private Film film; // una recensione riguarda un film
    @ManyToOne private Utente utente; // una recensione è scritta da un utente registrato; Un utente può inserire al massimo una recensione per uno stesso film.
     
    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public java.time.LocalDateTime getData() {
        return data;
    }

    public void setData(java.time.LocalDateTime data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    

}
