package br.unitins.tp1.model.pedido;

import java.time.LocalDate;

import br.unitins.tp1.model.DefaultEntity;
import br.unitins.tp1.model.capacete.Capacete;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Estoque extends DefaultEntity {

    @ManyToOne
    @JoinColumn(name = "id_capacete")
    private Capacete capacete;
    private LocalDate data;
    private String codigo;
    private Integer estoque;

    public Capacete getCapacete() {
        return capacete;
    }

    public void setCapacete(Capacete capacete) {
        this.capacete = capacete;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

}
