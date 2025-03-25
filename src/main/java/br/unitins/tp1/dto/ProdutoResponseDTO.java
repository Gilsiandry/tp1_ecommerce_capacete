package br.unitins.tp1.dto;

import br.unitins.tp1.model.Produto;


public record ProdutoResponseDTO(
    Long id,
    String nome,
    String marca,
    String modelo,
    String cor,
    int tamanho,
    Double preco) {

    public static ProdutoResponseDTO valueOf(Produto produto) {
        if (produto == null)
            return null;
        return new ProdutoResponseDTO(produto.getId(), produto.getNome(), produto.getMarca(), produto.getModelo(), produto.getCor(), produto.getTamanho(), produto.getPreco());
    }
    
}