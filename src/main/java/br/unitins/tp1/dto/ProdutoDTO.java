package br.unitins.tp1.dto;

public record ProdutoDTO(
    String nome,
    String marca,
    String modelo,
    String cor,
    int tamanho,
    Double preco) {
    
}