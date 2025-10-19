package br.unitins.tp1.dto.capacete;

import br.unitins.tp1.model.capacete.Viseira;

public record ViseiraResponseDTO(
        Long id,
        String marca,
        String tipo) {
    public static ViseiraResponseDTO valueOf(Viseira viseira) {
        return new ViseiraResponseDTO(viseira.getId(), viseira.getMarca(), Viseira.getTipo());
    }
}