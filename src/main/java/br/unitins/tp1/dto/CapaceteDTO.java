package br.unitins.tp1.dto;

public record CapaceteDTO(
    String nome,
    String marca,
    String categoria,
    String modelo,
    String cor,
    int tamanho,
    Double preco) {
    
}