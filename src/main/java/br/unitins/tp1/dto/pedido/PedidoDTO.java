package br.unitins.tp1.dto.pedido;

import java.util.List;

public record PedidoDTO(

    // pagamento
    // endereco
    Double total,
    List<ItemPedidoDTO> itens) {
    
}