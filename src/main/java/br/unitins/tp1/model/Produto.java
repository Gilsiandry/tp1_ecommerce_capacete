package br.unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Produto extends DefaultEntity {

    @Column(length = 30, nullable = false)
    private String nome;

    @Column(length = 30, nullable = false)
    private String marca;

    @Column(length = 30, nullable = false)
    private String modelo;

    @Column(length = 20, nullable = false)
    private String cor;

    @Column(nullable = false)
    private int tamanho;

    @Column(nullable = false)
    private Double preco;

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
