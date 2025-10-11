package br.unitins.tp1.dto.capacete;

import jakarta.validation.constraints.NotBlank;

public record FabricanteRequestDTO(
        @NotBlank(message = "O campo nome deve ser informado.")
        String nome) {

}