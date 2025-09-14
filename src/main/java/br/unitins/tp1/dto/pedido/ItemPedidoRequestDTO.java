package br.unitins.tp1.dto.pedido;

import jakarta.validation.constraints.NotNull;

public record ItemPedidoRequestDTO(
                @NotNull(message = "O campo id produto deve ser informado") Long idProduto,
                @NotNull(message = "O campo quantidade deve ser informado") Integer quantidade,
                @NotNull(message = "O campo preco deve ser informado") Double preco){

}