package br.unitins.tp1.dto.usuario.patches;

import jakarta.validation.constraints.NotBlank;

public record NomePatchDTO(
    @NotBlank
    String novoNome
) {
    
}
