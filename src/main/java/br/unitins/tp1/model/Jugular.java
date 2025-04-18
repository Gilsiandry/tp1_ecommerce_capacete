package br.unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Jugular extends DefaultEntity {

    @Column(length = 30, nullable = false)
    private String tipoFechamento;

    

    public String getTipoFechamento() {
        return tipoFechamento;
    }

    public void setNome(String tipoFechamento) {
        this.tipoFechamento = tipoFechamento;
    }
}
