package it.uniroma3.siw_festival.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;
//import java.util.Objects;

@Entity
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private Integer anno;
    private String città;
    private java.time.LocalDate dataInizio;
    private java.time.LocalDate dataFine;
    private String descrizione;

    // un festival presenta più film
    @ManyToMany(mappedBy = "festivals")
    private List<Film> film;

    // un festival prevede più proiezioni
    @OneToMany(mappedBy = "festival")
    private List<Proiezione> proiezioni;

    public String getNome() {
        return nome;
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
}
