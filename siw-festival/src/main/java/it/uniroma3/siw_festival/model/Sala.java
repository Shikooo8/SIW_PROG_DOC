package it.uniroma3.siw_festival.model;

import java.util.List;

import jakarta.persistence.OneToMany;

public class Sala {

    private String nome;
    private String indirizzo;
    private Integer capienza;
    
    @OneToMany(mappedBy = "sala") private List<Proiezione> proiezioni;  //una sala può ospitare più proiezioni

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Integer getCapienza() {
        return capienza;
    }

    public void setCapienza(Integer capienza) {
        this.capienza = capienza;
    }

}
