package it.uniroma3.siw_festival.model;

import jakarta.persistence.ManyToOne;

public class Proiezione {

    private java.time.LocalDate data;
    private java.time.LocalTime ora;
    private String stato;

    
    @ManyToOne private Festival festival; //una proiezione appartiene a un festival
    
    @ManyToOne private Film film;//una proiezione riguarda un film
    
    @ManyToOne private Sala sala; // una proiezione si svolge in una sala
    
    public java.time.LocalDate getData() {
        return data;
    }

    public void setData(java.time.LocalDate data) {
        this.data = data;
    }

    public java.time.LocalTime getOra() {
        return ora;
    }

    public void setOra(java.time.LocalTime ora) {
        this.ora = ora;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

}
