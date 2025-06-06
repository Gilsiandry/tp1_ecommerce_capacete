package br.unitins.tp1.dto.pedido;

import java.time.LocalDateTime;

import br.unitins.tp1.model.pedido.SituacaoPedido;
import br.unitins.tp1.model.pedido.StatusPedido;

public record StatusPedidoResponseDTO(
    LocalDateTime dataAtualizacao,
    SituacaoPedido situacaoPedido
) {

    public static StatusPedidoResponseDTO valueOf(StatusPedido statusPedido) {
        return new StatusPedidoResponseDTO(
            statusPedido.getDataAtualizacao(),
            statusPedido.getSituacaoPedido());
    }
    
}
