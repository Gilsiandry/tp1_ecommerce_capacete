package br.unitins.tp1.dto.usuario;

import br.unitins.tp1.model.usuario.Funcionario;

public record FuncionarioResponseDTO(
    Long id,
    Double altura,
    String nomeImagem,
    UsuarioResponseDTO usuario
) {
    
    public static FuncionarioResponseDTO valueOf(Funcionario funcionario) {
        return new FuncionarioResponseDTO(
            funcionario.getId(),
            funcionario.getAltura(),
            funcionario.getNomeImagem(),
            UsuarioResponseDTO.valueOf(funcionario.getUsuario()));
    }
}
