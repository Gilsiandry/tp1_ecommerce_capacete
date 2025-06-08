package br.unitins.tp1.dto.usuario;

import br.unitins.tp1.model.PessoaJuridica;

public record PessoaJuridicaResponseDTO(
    Long id,
    String nome,
    String cnpj) {

    public static PessoaJuridicaResponseDTO valueOf(PessoaJuridica pessoaJuridica) {
        if (pessoaJuridica == null)
            return null;
        return new PessoaJuridicaResponseDTO(pessoaJuridica.getId(), 
                                           pessoaJuridica.getNome(), 
                                           pessoaJuridica.getCnpj());
    }
    
}