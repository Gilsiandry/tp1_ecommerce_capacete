package br.unitins.tp1.model.capacete;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.OBJECT)
public enum CorViseira {

        FUME(1, "Fumê"),
        CRISTAL(2, "Cristal"),
        IRIDIUM(3, "Iridium"),
        CAMALEAO(4, "Camaleão"),
        CROMADA(5, "Cromada"),
        DOURADA(6, "Dourada");

    private final Integer id;
    private final String label;

    private CorViseira(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static CorViseira fromId(Integer id) {
        if (id == null)
            throw new IllegalArgumentException("Id não pode ser nulo.");
        for (CorViseira tipo : values()) {
            if (tipo.getId().equals(id))
                return tipo;
        }
        throw new IllegalArgumentException("Nenhuma cor de viseira encontrada para id: " + id);
    }
}
