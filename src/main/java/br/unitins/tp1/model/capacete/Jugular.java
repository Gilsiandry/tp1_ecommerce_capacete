package br.unitins.tp1.model.capacete;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.unitins.tp1.validation.EntidadeNotFoundException;

@JsonFormat(shape = Shape.OBJECT)
public enum Jugular {

        ENGATERAPIDO(1, "Engate Rápido"), DUPLOD(2, "Duplo D");

    private final Integer id;
    private final String label;

    private Jugular(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Jugular valueOf(Integer id) {
        if (id.equals(null))
            return null;
        for (Jugular tipo : values()) {
            if (tipo.getId().equals(id))
                return tipo;
        }

        throw new EntidadeNotFoundException("idJugular", "Tipo de jugular não encontrada!");
    }

}
