package br.unitins.tp1.dto;

import br.unitins.tp1.model.Jugular;


public record JugularResponseDTO(
    Long id,
    String tipoFechamento,
    CapaceteResponseDTO capacete) {

    public static JugularResponseDTO valueOf(Jugular jugular) {
        if (jugular == null)
            return null;
        return new JugularResponseDTO(
            jugular.getId(), 
            jugular.getTipoFechamento(), 
            CapaceteResponseDTO.valueOf(jugular.getCapacete())
        );
    }
}