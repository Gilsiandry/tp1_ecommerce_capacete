package br.unitins.tp1.dto.pedido;

import java.time.LocalDateTime;

import br.unitins.tp1.model.pagamento.TipoPagamento;
import br.unitins.tp1.model.pedido.Pedido;
import br.unitins.tp1.model.pedido.SituacaoPedido;

public record PedidoBasicoResponseDTO(
                Long id,
                LocalDateTime data,
                Double valorTotal,
                SituacaoPedido situacaoPedido,
                TipoPagamento tipoPagamento) {

        public static PedidoBasicoResponseDTO valueOf(Pedido pedido) {
                return new PedidoBasicoResponseDTO(
                                pedido.getId(),
                                pedido.getData(),
                                pedido.getValorTotal(),
                                pedido.getStatusPedido().getLast().getSituacaoPedido(),
                                pedido.getPagamento() != null ? pedido.getPagamento().getTipoPagamento()
                                                : TipoPagamento.NAO_REALIZADO);
        }
}