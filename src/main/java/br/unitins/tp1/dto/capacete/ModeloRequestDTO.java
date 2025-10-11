package br.unitins.tp1.dto.capacete;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ModeloRequestDTO(
        @NotBlank(message = "O campo nome deve ser informado.")
        String nome,

        @NotNull(message = "Marca obrigatória.")
        Long idMarca) {

}