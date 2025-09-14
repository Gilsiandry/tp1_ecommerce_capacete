package br.unitins.tp1.dto.pedido;

import br.unitins.tp1.model.pedido.ItemPedido;

public record ItemPedidoResponseDTO(
        Long idProduto,
        String nome,
        Integer quantidade,
        Double valor
        )

{
    public static ItemPedidoResponseDTO valueOf(ItemPedido itemPedido){
        return new ItemPedidoResponseDTO(itemPedido.getLote().getCapacete().getId(), itemPedido.getLote().getCapacete().getNome(), itemPedido.getQuantidade(), itemPedido.getPreco());
    }
}