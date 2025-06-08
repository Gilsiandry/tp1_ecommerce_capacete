package br.unitins.tp1.dto.pedido;

import java.time.LocalDate;

import br.unitins.tp1.model.pedido.Estoque;

public record EstoqueResponseDTO(
    Long id,
    String codigo,
    LocalDate data,
    Integer estoque,
    Long idCapacete
) {

    public static EstoqueResponseDTO valueOf(Estoque estoque) {
        return new EstoqueResponseDTO(
            estoque.getId(),
            estoque.getCodigo(),
            estoque.getData(),
            estoque.getEstoque(),
            estoque.getCapacete().getId()
        );

    }
    
}
