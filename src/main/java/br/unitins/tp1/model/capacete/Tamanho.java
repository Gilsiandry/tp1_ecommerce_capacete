package br.unitins.tp1.model.capacete;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


@JsonFormat(shape = Shape.OBJECT)
public enum Tamanho {

    T56(1, "56"), 
    T58(2, "58"), 
    T60(3, "60"), 
    T62(4, "62");

    private final Integer id;
    private final String label;

    private Tamanho(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Tamanho fromId(Integer id) {
        if (id == null)
            throw new IllegalArgumentException("Id não pode ser nulo.");
        for (Tamanho tipo : values()) {
            if (tipo.getId().equals(id))
                return tipo;
        }
        throw new IllegalArgumentException("Nenhum tamanho encontrado para id: " + id);
    }
}