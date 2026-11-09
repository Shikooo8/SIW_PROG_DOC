package it.uniroma3.siw_festival.model;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity 
public class Proiezione {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private java.time.LocalDate data;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private java.time.LocalTime ora;
    
    @Enumerated(EnumType.STRING)
    private StatoProiezione stato;

    @JsonIgnore 
    @ManyToOne 
    private Festival festival;      //una proiezione appartiene a un festival
    
    @JsonIgnore 
    @NotNull 
    @ManyToOne 
    private Film film;              //una proiezione riguarda un film
    
    @JsonIgnore 
    @NotNull 
    @ManyToOne 
    private Sala sala;              // una proiezione si svolge in una sala





//==================== EQUALS & HASHCODE ==============    



@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((data == null) ? 0 : data.hashCode());
    result = prime * result + ((ora == null) ? 0 : ora.hashCode());
    result = prime * result + ((sala == null) ? 0 : sala.hashCode());
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
    Proiezione other = (Proiezione) obj;
    if (data == null) {
        if (other.data != null)
            return false;
    } else if (!data.equals(other.data))
        return false;
    if (ora == null) {
        if (other.ora != null)
            return false;
    } else if (!ora.equals(other.ora))
        return false;
    if (sala == null) {
        if (other.sala != null)
            return false;
    } else if (!sala.equals(other.sala))
        return false;
    return true;
}
//=================== GETTERS & SETTERS ===============

    
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }


    
    

}
