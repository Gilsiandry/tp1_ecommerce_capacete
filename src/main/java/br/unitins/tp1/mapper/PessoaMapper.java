/*package br.unitins.tp1.mapper;

import br.unitins.tp1.dto.PessoaDTO;
import br.unitins.tp1.dto.PessoaFisicaDTO;
import br.unitins.tp1.dto.PessoaJuridicaDTO;
import br.unitins.tp1.model.Pessoa;
import br.unitins.tp1.model.PessoaFisica;
import br.unitins.tp1.model.PessoaJuridica;

public class PessoaMapper {

    public static Pessoa toEntity(PessoaDTO dto) {
        Pessoa pessoa;
        
        if (dto instanceof PessoaFisicaDTO) {
            PessoaFisicaDTO pf = (PessoaFisicaDTO) dto;

            PessoaFisica p = new PessoaFisica();
            p.setNome(pf.nome());
            p.setCpf(pf.cpf());

            pessoa = p;

        } else if (dto instanceof PessoaJuridicaDTO) {
            PessoaJuridicaDTO pj = (PessoaJuridicaDTO) dto;

            PessoaJuridica p = new PessoaJuridica();
            p.setNome(pj.nome());
            p.setCnpj(pj.cnpj());

            pessoa = p;
        } else {
            throw new IllegalArgumentException("Tipo de pessoa inválido");
        }

        return pessoa;
    }
}
*/