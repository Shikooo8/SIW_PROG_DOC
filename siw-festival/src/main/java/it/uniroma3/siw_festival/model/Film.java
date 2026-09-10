package it.uniroma3.siw_festival.model;

import java.util.List;

import it.uniroma3.siw_festival.validation.NotFutureYear;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank 
    private String titolo;
    
    @NotNull 
    @Min(1890)
    @NotFutureYear
    private Integer anno;

    @Min(0)
    @Max(300)
    private Integer durata;

    private String genere;
    
    private String paeseProduzione;

    @OneToMany(mappedBy = "film")
    private List<Proiezione> proiezioni;        // un film può avere più proiezioni
    
    @ManyToMany 
    private List<Festival> festivals;           // un film può partecipare a uno o più festival
    
    @ManyToOne
    private Regista regista;                    // ogni film ha un regista
    
    @OneToMany(mappedBy = "film")
    private List<Recensione> recensioni;        // un film può avere più recensioni


//==================== EQUALS & HASHCODE ==============    



//=================== GETTERS & SETTERS ===============


    public String getTitolo() {
        return titolo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titolo == null) ? 0 : titolo.hashCode());
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
        Film other = (Film) obj;
        if (titolo == null) {
            if (other.titolo != null)
                return false;
        } else if (!titolo.equals(other.titolo))
            return false;
        if (anno == null) {
            if (other.anno != null)
                return false;
        } else if (!anno.equals(other.anno))
            return false;
        return true;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Proiezione> getProiezioni() {
        return proiezioni;
    }

    public void setProiezioni(List<Proiezione> proiezioni) {
        this.proiezioni = proiezioni;
    }

    public List<Festival> getFestivals() {
        return festivals;
    }

    public void setFestivals(List<Festival> festivals) {
        this.festivals = festivals;
    }

    public Regista getRegista() {
        return regista;
    }

    public void setRegista(Regista regista) {
        this.regista = regista;
    }

    public List<Recensione> getRecensioni() {
        return recensioni;
    }

    public void setRecensioni(List<Recensione> recensioni) {
        this.recensioni = recensioni;
    }

    

}
