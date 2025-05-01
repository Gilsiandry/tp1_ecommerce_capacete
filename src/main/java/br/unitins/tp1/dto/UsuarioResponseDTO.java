package br.unitins.tp1.dto;

import br.unitins.tp1.model.Usuario;
import br.unitins.tp1.model.Perfil;
import br.unitins.tp1.model.Pessoa;

public record UsuarioResponseDTO(
    Long id, 
    String email,
    String senha,
    Perfil perfil,
    Pessoa pessoa) {


    public static UsuarioResponseDTO valueOf(Usuario usuario){
        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getEmail(),
            usuario.getSenha(),
            usuario.getPerfil(),
            usuario.getPessoa());

    }
}