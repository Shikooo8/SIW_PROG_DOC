package it.uniroma3.siw_festival.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity 
public class Regista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank 
    private String nome;
    
    @NotBlank 
    private String cognome;
    
    private java.time.LocalDate dataNascita;
    
    private String nazionalità;

    @OneToMany(mappedBy = "regista")
    private List<Film> film;                        // un regista può aver diretto più film


    //==================== EQUALS & HASHCODE ==============    

//TODO


//=================== GETTERS & SETTERS ===============


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public java.time.LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(java.time.LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getNazionalità() {
        return nazionalità;
    }

    public void setNazionalità(String nazionalità) {
        this.nazionalità = nazionalità;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Film> getFilm() {
        return film;
    }

    public void setFilm(List<Film> film) {
        this.film = film;
    }

    
}
