package it.uniroma3.siw_festival.dto;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.siw_festival.validation.NotFutureYear;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FilmForm {
    private Long id;
    @NotBlank
    @Size(max = 200)
    private String titolo;
    @NotNull @Min(1888) @NotFutureYear 
    private Integer anno;
    @NotNull @Min(1)
    private Integer durata;
    private String genere;
    private String paeseProduzione;
    @NotBlank
    private String regista;
    private List<Long> festivalIds = new ArrayList<>();
    @Valid
    private List<InterpretazioneForm> cast = new ArrayList<>();



    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
    public String getRegista() {
        return regista;
    }
    public void setRegista(String regista) {
        this.regista = regista;
    }
    public List<Long> getFestivalIds() {
        return festivalIds;
    }
    public void setFestivalIds(List<Long> festivalIds) {
        this.festivalIds = festivalIds;
    }
    public List<InterpretazioneForm> getCast() {
        return cast;
    }
    public void setCast(List<InterpretazioneForm> cast) {
        this.cast = cast;
    }
    


    
}