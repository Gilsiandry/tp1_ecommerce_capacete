package br.unitins.tp1.dto.capacete;

import jakarta.validation.constraints.NotBlank;

public record MarcaRequestDTO(
        @NotBlank(message = "O campo nome deve ser informado.")
        String nome,

        @NotBlank(message = "O campo modelo deve ser informado.")
        String modelo) {

}