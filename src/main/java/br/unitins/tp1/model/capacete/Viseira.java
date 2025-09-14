package br.unitins.tp1.model.capacete;


import br.unitins.tp1.model.DefaultEntity;
import jakarta.persistence.Entity;

@Entity
public class Viseira extends DefaultEntity {

    private String marca;
    private String cor;
    private String tipo;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

       public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

       public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
