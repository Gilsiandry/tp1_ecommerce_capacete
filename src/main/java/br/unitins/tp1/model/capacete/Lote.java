package br.unitins.tp1.model.capacete;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Lote extends DefaultEntity {

    @Column(length = 30, nullable = false)
    private String codigo;

    @Column(length = 30, nullable = false)
    private LocalDate dataFabricacao;

    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

      public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }
}
