package br.unitins.tp1.dto.capacete;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AcessorioDTO(
    @NotBlank(message = "O nome deve ser informado.")
    @Size(min = 4, max = 40, message = "O nome deve possuir entre 4 a 40 caracteres.")
    String nome,

    @NotBlank(message = "A cor deve ser informada.")
    @Size(min = 2, max = 40, message = "A cor deve possuir entre 2 e 40 caracteres.")
    String cor) {

    }