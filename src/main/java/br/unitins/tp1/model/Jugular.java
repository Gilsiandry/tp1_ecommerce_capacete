package br.unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Jugular extends DefaultEntity {

    @Column(length = 30, nullable = false)
    private String tipoFechamento;

    @ManyToOne
    @JoinColumn(name = "id_capacete")
    private Capacete capacete;

    

    public String getTipoFechamento() {
        return tipoFechamento;
    }

    public void setNome(String tipoFechamento) {
        this.tipoFechamento = tipoFechamento;
    }

    
      public Capacete getCapacete() {
        return capacete;
    }

    public void setCapacete(Capacete capacete) {
        this.capacete = capacete;
    }


    
}
