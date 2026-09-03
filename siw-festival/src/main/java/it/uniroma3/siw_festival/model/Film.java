package it.uniroma3.siw_festival.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titolo;
    private Integer anno;
    private Integer durata;
    private String genere;
    private String paeseProduzione;

    @OneToMany(mappedBy = "film")
    List<Proiezione> proiezioni; // un film può avere più proiezioni
    @ManyToMany 
    private List<Festival> festivals;// un film può partecipare a uno o più festival
    @ManyToOne
    private Regista regista; // ogni film ha un regista
    @OneToMany(mappedBy = "film")
    List<Recensione> recensioni; // un film può avere più recensioni

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getPaeseProduzione() {
        return paeseProduzione;
    }

    public void setPaeseProduzione(String paeseProduzione) {
        this.paeseProduzione = paeseProduzione;
    }

}
