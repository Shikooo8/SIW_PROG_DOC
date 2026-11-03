package it.uniroma3.siw_festival.model;

import java.util.HashMap;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;


public class Attore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank 
    private String nome;
    
    @NotBlank 
    private String cognome;
    
    private java.time.LocalDate dataNascita;
    
    private String nazionalità;

    @ManyToMany(mappedBy = "attori") //TODO ha senso una hashmap??? allyosha
    private HashMap<Film, String> films;                        // attori in più films


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

    public HashMap<Film, String> getFilm() {
        return films;
    }

    public void setFilm(HashMap<Film, String> films) {
        this.films = films;
    }

    

}
