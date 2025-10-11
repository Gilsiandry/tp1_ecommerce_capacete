package br.unitins.tp1.dto.capacete;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ViseiraRequestDTO(
        @NotBlank(message = "O campo marca deve ser informado.")
        String marca,

        @NotBlank(message = "O campo tipo deve ser informado.")
        String tipo,

        @NotNull(message = "Cor da Viseira obrigatório.")
        Long idCorViseira) {

}