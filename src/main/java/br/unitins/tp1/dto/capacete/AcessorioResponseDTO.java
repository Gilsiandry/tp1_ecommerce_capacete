package br.unitins.tp1.dto.capacete;

import br.unitins.tp1.model.acessorio.capacete;
import br.unitins.tp1.model.capacete.Acessorio;


public record AcessorioResponseDTO(
    Long id,
    String nome,
    String cor) {

    public static AcessorioResponseDTO valueOf(Acessorio acessorio) {
        if (acessorio == null)
            return null;
        return new AcessorioResponseDTO(acessorio.getId(), acessorio.getNome(), acessorio.getCor());
    }
}