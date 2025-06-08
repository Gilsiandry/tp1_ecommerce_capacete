package br.unitins.tp1.dto.capacete;

import br.unitins.tp1.model.Jugular;


public record JugularResponseDTO(
    Long id,
    String tipoFechamento) {

    public static JugularResponseDTO valueOf(Jugular jugular) {
        if (jugular == null)
            return null;
        return new JugularResponseDTO(jugular.getId(), jugular.getTipoFechamento());
    }
}