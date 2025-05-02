package br.unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
public class Informacao extends DefaultEntity {

    @Column(length = 400, nullable = false)
    private String descricao;

    @Column(length = 30, nullable = false)
    private Integer anolancamento;

    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

      public Integer getAnoLancamento() {
        return anolancamento;
    }

    public void setAnoLancamento(Integer anolancamento) {
        this.anolancamento = anolancamento;
    }
}
