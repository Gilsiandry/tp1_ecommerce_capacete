package br.unitins.tp1.dto.pedido;

import br.unitins.tp1.model.pedido.SituacaoPedido;
import jakarta.validation.constraints.NotNull;

public record StatusPedidoDTO(
    @NotNull(message = "O campo situacaoPedido deve ser informado")
    SituacaoPedido situacaoPedido
) {
    
}
