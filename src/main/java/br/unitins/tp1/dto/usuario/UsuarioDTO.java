package br.unitins.tp1.dto.usuario;

import br.unitins.tp1.model.Perfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
    @NotBlank(message = "O email não pode ser vazio")
    @Size(max = 50, message = "O email deve ter no máximo 50 caracteres")
    String username,

    @NotBlank(message = "A senha não pode ser vazia")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    String senha,

    Perfil perfil,
    
    PessoaDTO pessoa
){
}
