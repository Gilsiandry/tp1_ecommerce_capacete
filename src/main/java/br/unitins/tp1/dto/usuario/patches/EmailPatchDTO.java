package br.unitins.tp1.dto.usuario.patches;

import jakarta.validation.constraints.Email;

public record EmailPatchDTO(
    @Email
    String novoEmail
) {
    
}
