package br.unitins.tp1.dto.capacete;

import br.unitins.tp1.model.capacete.Marca;

public record MarcaResponseDTO(
        Long id,
        String nome) {
    public static MarcaResponseDTO valueOf(Marca marca) {
        return new MarcaResponseDTO(marca.getId(), marca.getNome());
    }
}