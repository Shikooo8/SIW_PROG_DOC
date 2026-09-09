package it.uniroma3.siw_festival.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RecensioneForm {

    @NotBlank
    private String testo;

    @NotNull
    @Min(1)
    @Max(10)
    private Integer voto;

    public String getTesto() { return testo; }
    public void setTesto(String testo) { this.testo = testo; }
    public Integer getVoto() { return voto; }
    public void setVoto(Integer voto) { this.voto = voto; }
}