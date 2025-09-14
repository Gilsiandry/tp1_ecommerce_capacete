package br.unitins.tp1.dto.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.tp1.dto.pedido.ItemPedidoResponseDTO;
import br.unitins.tp1.dto.pagamento.PagamentoResponseDTO;
import br.unitins.tp1.model.pedido.Pedido;
import br.unitins.tp1.model.pedido.StatusPedido;

public record PedidoResponseDTO(
                Long id,
                LocalDateTime data,
                Double valorTotal,
                List<ItemPedidoResponseDTO> itensPedidos,
                List<StatusPedido> statusPedidos,
                Object pagamento) {

       public static PedidoResponseDTO valueOf(Pedido pedido){
                return new PedidoResponseDTO(pedido.getId(),
                 pedido.getData(),
                 pedido.getValorTotal(),
                 pedido.getItensPedidos().stream().map(ItemPedidoResponseDTO::valueOf).toList(),
                 pedido.getStatusPedidos(),
                      PagamentoResponseDTO.valueOf(pedido.getPagamento()));
       }
}