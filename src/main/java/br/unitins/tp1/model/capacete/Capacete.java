package br.unitins.tp1.model.capacete;

import java.util.List;

import br.unitins.tp1.model.DefaultEntity;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

    @Entity
    public class Capacete extends DefaultEntity {

    private String nome;
    private Double preco;
    
    private Categoria categoria;
    private Jugular jugular;
    private Cor cor;
    private Tamanho tamanho;
    


    @ManyToOne
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "id_viseira")
    private Viseira viseira;

    @ElementCollection
    @CollectionTable(name = "imagens_capacete", joinColumns = @JoinColumn(name = "id_capacete"))
    @Column(name = "imagem")
    private List<String> imagens;
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    

    // public Marca getMarca() {
    //     return marca;
    // }

    // public void setMarca(Marca marca) {
    //     this.marca = marca;
    // }

    public Viseira getViseira() {
        return viseira;
    }

    public void setViseira(Viseira viseira) {
        this.viseira = viseira;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Jugular getJugular() {
        return jugular;
    }

    public void setJugular(Jugular jugular) {
        this.jugular = jugular;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }


    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }



    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }
}