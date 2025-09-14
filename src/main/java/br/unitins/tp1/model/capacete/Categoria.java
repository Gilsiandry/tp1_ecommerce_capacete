package br.unitins.tp1.model.capacete;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.unitins.tp1.validation.EntidadeNotFoundException;

@JsonFormat(shape = Shape.OBJECT)
public enum Categoria {

        FECHADO(1, "Fechado"), ABERTO(2, "Aberto"), ARTICULADO(2, "Articulado");

    private final Integer id;
    private final String label;

    private Categoria(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Categoria valueOf(Integer id) {
        if (id.equals(null))
            return null;
        for (Categoria tipo : values()) {
            if (tipo.getId().equals(id))
                return tipo;
        }

        throw new EntidadeNotFoundException("idCategoria", "Tipo de categoria não encontrada!");
    }

}