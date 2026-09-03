package it.uniroma3.siw_festival.model;

import jakarta.persistence.ManyToOne;

public class Recensione {

    private String testo;
    private Integer voto;
    private java.time.LocalDateTime data;

    @ManyToOne private Film film; // una recensione riguarda un film
    @ManyToOne private Utente utente; // una recensione è scritta da un utente registrato; Un utente può inserire al massimo una recensione per uno stesso film.
     
    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public java.time.LocalDateTime getData() {
        return data;
    }

    public void setData(java.time.LocalDateTime data) {
        this.data = data;
    }

}
