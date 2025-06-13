package br.unitins.tp1.dto.usuario;

import jakarta.validation.Valid;

public record ClienteBasicoDTO(
    @Valid
    UsuarioBasicoDTO usuario
) {
    
}