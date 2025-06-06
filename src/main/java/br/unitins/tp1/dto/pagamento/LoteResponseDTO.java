package br.unitins.tp1.dto;

import java.time.LocalDate;

import br.unitins.tp1.model.Lote;


public record LoteResponseDTO(
    Long id,
    String codigo,
    LocalDate dataFabricacao) {

    public static LoteResponseDTO valueOf(Lote lote) {
        if (lote == null)
            return null;
        return new LoteResponseDTO(lote.getId(), lote.getCodigo(), lote.getDataFabricacao());
    }
}