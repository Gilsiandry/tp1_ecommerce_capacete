package br.unitins.tp1.model.capacete;

import br.unitins.tp1.model.DefaultEntity;
import jakarta.persistence.Entity;

@Entity
public class Modelo extends DefaultEntity {

    private String nome;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}