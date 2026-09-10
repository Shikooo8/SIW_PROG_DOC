package it.uniroma3.siw_festival.model;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.ManyToMany;

@Entity
public class Festival {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank 
    private String nome;
    
    @NotNull 
    private Integer anno;
    
    @NotBlank 
    private String città;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.time.LocalDate dataInizio;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.time.LocalDate dataFine;
    
    private String descrizione;

    @ManyToMany(mappedBy = "festivals")
    private List<Film> film;                    // un festival presenta più film

    @OneToMany(mappedBy = "festival")
    private List<Proiezione> proiezioni;        // un festival prevede più proiezioni


//==================== EQUALS & HASHCODE ==============    




//=================== GETTERS & SETTERS ===============

    public String getNome() {
        return nome;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((anno == null) ? 0 : anno.hashCode());
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
        Festival other = (Festival) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (anno == null) {
            if (other.anno != null)
                return false;
        } else if (!anno.equals(other.anno))
            return false;
        return true;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public java.time.LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(java.time.LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public java.time.LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(java.time.LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
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

    public List<Proiezione> getProiezioni() {
        return proiezioni;
    }

    public void setProiezioni(List<Proiezione> proiezioni) {
        this.proiezioni = proiezioni;
    }

    
}
