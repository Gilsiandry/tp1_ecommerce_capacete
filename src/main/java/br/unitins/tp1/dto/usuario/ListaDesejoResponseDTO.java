package br.unitins.tp1.dto.usuario;

import br.unitins.tp1.model.capacete.Capacete;

public record ListaDesejoResponseDTO(
    Long idProduto,
    String nomeProduto
) {

    public static ListaDesejoResponseDTO valueOf(Capacete capacete) {
        return new ListaDesejoResponseDTO(
            capacete.getId(),
            capacete.getNome()
        );
    }
    
}
