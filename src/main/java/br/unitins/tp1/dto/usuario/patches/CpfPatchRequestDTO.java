package br.unitins.tp1.dto.usuario.patches;

import jakarta.validation.constraints.NotBlank;

public record CpfPatchRequestDTO(
    @NotBlank(message = "O campo cpf deve ser informado.")
    String cpf
) {
    
}
