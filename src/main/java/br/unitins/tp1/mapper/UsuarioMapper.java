// Arquivo: UsuarioMapper.java
/*package br.unitins.tp1.mapper;

import br.unitins.tp1.dto.PessoaFisicaDTO;
import br.unitins.tp1.dto.PessoaJuridicaDTO;
import br.unitins.tp1.dto.UsuarioDTO;
import br.unitins.tp1.model.Pessoa;
import br.unitins.tp1.model.PessoaFisica;
import br.unitins.tp1.model.PessoaJuridica;
import br.unitins.tp1.model.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.username());
        usuario.setSenha(dto.senha());

        Pessoa pessoa;
        
        if (dto.pessoa() instanceof PessoaFisicaDTO) {
            PessoaFisicaDTO pf = (PessoaFisicaDTO) dto.pessoa();

            PessoaFisica p = new PessoaFisica();
            p.setNome(pf.nome());
            p.setCpf(pf.cpf());

            pessoa = p;

        } else if (dto.pessoa() instanceof PessoaJuridicaDTO) {
            PessoaJuridicaDTO pj = (PessoaJuridicaDTO) dto.pessoa();

            PessoaJuridica p = new PessoaJuridica();
            p.setNome(pj.nome());
            p.setCnpj(pj.cnpj());

            pessoa = p;
        } else {
            throw new IllegalArgumentException("Tipo de pessoa inválido");
        }

        usuario.setPessoaFisica((PessoaFisica)pessoa);

        return usuario;
    }

}
*/