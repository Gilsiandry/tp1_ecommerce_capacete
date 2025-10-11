package br.unitins.tp1.dto.capacete;

import br.unitins.tp1.model.capacete.Modelo;

public record ModeloResponseDTO(
        Long id,
        String nome) {
    public static ModeloResponseDTO valueOf(Modelo modelo) {
        return new ModeloResponseDTO(modelo.getId(), modelo.getNome());
    }
}