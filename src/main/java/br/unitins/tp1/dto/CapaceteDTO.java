package br.unitins.tp1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Positive;

public record CapaceteDTO(
    @NotBlank(message = "O nome deve ser informado.")
    @Size(min = 4, max = 40, message = "O nome deve possuir entre 4 a 40 caracteres.")
    String nome,

    @NotBlank(message = "A marca deve ser informada.")
    @Size(min = 3, max = 40, message = "A marca deve possuir entre 3 a 40 caracteres.")
    String marca,

    @NotBlank(message = "A categoria deve ser informada.")
    @Size(min = 2, max = 40, message = "A categoria deve possuir entre 2 e 40 caracteres.")
    String categoria,

    @NotBlank(message = "O modelo deve ser informado.")
    @Size(min = 2, max = 60, message = "O modelo deve possuir entre 2 e 60 caracteres.")
    String modelo,

    @NotBlank(message = "A cor deve ser informada.")
    @Size(min = 3, max = 30, message = "A cor deve possuir entre 3 e 30 caracteres.")
    String cor,

    @NotBlank(message = "O tamanho deve ser informado.")
    @Size(min = 2, max = 2, message = "O tamanho deve possuir 2 caracteres.")
    String tamanho,

    @NotNull(message = "O preço deve ser informado.")
    @Positive(message = "O preço deve ser maior que zero.")
    Double preco) {

    }



/*public record CapaceteDTO(
    String nome,
    String marca,
    String categoria,
    String modelo,
    String cor,
    int tamanho,
    Double preco) {
    
}*/