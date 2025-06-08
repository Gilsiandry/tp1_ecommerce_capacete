package br.unitins.tp1.dto.pedido;

public record ItemPedidoDTO(
    Long idProduto,
    Double preco,
    Integer qtd
    // desconto
    ) {
    
}