package br.unitins.tp1.dto.usuario;

import jakarta.validation.Valid;

public record ClienteDTO(
    @Valid
    UsuarioDTO usuario
) {
    
}
