package br.unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Acessorio extends DefaultEntity {

    @Column(length = 30, nullable = false)
    private String nome;

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
