package br.unitins.tp1.dto.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SenhaPatchDTO(
        @NotBlank(message = "A senha não pode ser nula ou vazia") @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres") String senha) {

}
