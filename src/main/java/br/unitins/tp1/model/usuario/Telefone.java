package br.unitins.tp1.ironforge.model.usuario;

import br.unitins.tp1.ironforge.model.DefaultEntity;
import jakarta.persistence.Entity;

@Entity
public class Telefone extends DefaultEntity {

    private String codigoArea;
    private String numero;

    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
