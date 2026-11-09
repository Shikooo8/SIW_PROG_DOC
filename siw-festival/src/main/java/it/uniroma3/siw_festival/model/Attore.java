package it.uniroma3.siw_festival.model;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity 
public class Attore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank 
    private String nome;
    
    @NotBlank 
    private String cognome;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private java.time.LocalDate dataNascita;
    
    private String nazionalità;

    @JsonIgnore @OneToMany(mappedBy = "attore") private 
    List<Interpretazione> interpretazioni;


    //==================== EQUALS & HASHCODE ==============    



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
        result = prime * result + ((dataNascita == null) ? 0 : dataNascita.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Attore other = (Attore) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (cognome == null) {
            if (other.cognome != null)
                return false;
        } else if (!cognome.equals(other.cognome))
            return false;
        if (dataNascita == null) {
            if (other.dataNascita != null)
                return false;
        } else if (!dataNascita.equals(other.dataNascita))
            return false;
        return true;
    }

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

    public List<Interpretazione> getInterpretazioni() {
        return interpretazioni;
    }

    public void setInterpretazioni(List<Interpretazione> interpretazioni) {
        this.interpretazioni = interpretazioni;
    }


    

}
