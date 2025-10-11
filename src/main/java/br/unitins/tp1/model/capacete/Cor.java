package br.unitins.tp1.model.capacete;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.OBJECT)
public enum Cor {

        PRETO(1, "Preto"),
        VERMELHO(2, "Vermelho"),
        AZUL(3, "Azul"),
        BRANCO(4, "Branco"),
        VERDE(5, "Verde"),
        AMARELO(6, "Amarelo"), 
        ROSA(7, "Rosa"),
        ROXO(8, "Roxo"),
        LARANJA(9, "Laranja"),
        MARROM(10, "Marrom"),
        CINZA(11, "Cinza");

    private final Integer id;
    private final String label;

    private Cor(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Cor fromId(Integer id) {
        if (id == null)
            throw new IllegalArgumentException("Id não pode ser nulo.");
        for (Cor tipo : values()) {
            if (tipo.getId().equals(id))
                return tipo;
        }
        throw new IllegalArgumentException("Nenhuma cor encontrada para o id: " + id);
    }
}
