package br.unitins.tp1.model.capacete;


import java.util.List;

import br.unitins.tp1.model.DefaultEntity;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

@Entity
public class Viseira extends DefaultEntity {

    
    private String tipo;

    private Marca marca;
    private CorViseira corViseira;

    @ElementCollection
    @CollectionTable(name = "imagens_capacete", joinColumns = @JoinColumn(name = "id_capacete"))
    @Column(name = "imagem")
    private List<String> imagens;


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public CorViseira getCorViseira() {
        return corViseira;
    }

    public void setCoViseira(CorViseira corViseira) {
        this.corViseira = corViseira;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }

}
