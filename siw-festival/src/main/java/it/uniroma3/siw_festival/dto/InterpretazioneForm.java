package it.uniroma3.siw_festival.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;

public class InterpretazioneForm {
    private Long id;                       // id dell'interpretazione esistente (null se nuova)
    @NotBlank
    private String personaggio;
    private Long attoreId;                 // attore scelto dall'elenco, oppure null...
    private String nome;                   // ...e allora si usano questi per crearne uno nuovo
    private String cognome;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascita;
    private String nazionalita;
    private String attoreLabel;
    
    public String getAttoreLabel() {
        return attoreLabel;
    }
    public void setAttoreLabel(String attoreLabel) {
        this.attoreLabel = attoreLabel;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPersonaggio() {
        return personaggio;
    }
    public void setPersonaggio(String personaggio) {
        this.personaggio = personaggio;
    }
    public Long getAttoreId() {
        return attoreId;
    }
    public void setAttoreId(Long attoreId) {
        this.attoreId = attoreId;
    }
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
    public LocalDate getDataNascita() {
        return dataNascita;
    }
    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }
    public String getNazionalita() {
        return nazionalita;
    }
    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }



}