package br.unitins.tp1.model.capacete;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


@JsonFormat(shape = Shape.OBJECT)
public enum Categoria {

        FECHADO(1, "Fechado"),
        ABERTO(2, "Aberto"),
        ARTICULADO(3, "Articulado");

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

    public static Categoria fromId(Integer id) {
        if (id == null)
            throw new IllegalArgumentException("Id não pode ser nulo.");
        for (Categoria tipo : values()) {
            if (tipo.getId().equals(id))
                return tipo;
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para id: " + id);
    }
}