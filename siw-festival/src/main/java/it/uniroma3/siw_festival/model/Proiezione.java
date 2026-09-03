package it.uniroma3.siw_festival.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

public class Proiezione {

    private java.time.LocalDate data;
    private java.time.LocalTime ora;
    @Enumerated(EnumType.STRING)
    private StatoProiezione stato;

    
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

    public StatoProiezione getStato() {
        return stato;
    }

    public void setStato(StatoProiezione stato) {
        this.stato = stato;
    }

    

}
