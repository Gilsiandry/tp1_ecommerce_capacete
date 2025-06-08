package br.unitins.tp1.service.usuario;

import java.util.List;

import br.unitins.tp1.dto.TelefoneDTO;
import br.unitins.tp1.dto.endereco.EnderecoDTO;
import br.unitins.tp1.dto.usuario.FuncionarioDTO;
import br.unitins.tp1.dto.usuario.FuncionarioUpdateDTO;
import br.unitins.tp1.dto.usuario.patches.CpfPatchDTO;
import br.unitins.tp1.dto.usuario.patches.DataNascimentoPatchDTO;
import br.unitins.tp1.dto.usuario.patches.EmailPatchDTO;
import br.unitins.tp1.dto.usuario.patches.NomePatchDTO;
import br.unitins.tp1.dto.usuario.patches.SenhaPatchDTO;
import br.unitins.tp1.model.usuario.Funcionario;

public interface FuncionarioService {

    Funcionario findById(Long id);

    List<Funcionario> findByNome(String nome);

    Funcionario findByUsuario (String email);

    List<Funcionario> findAll();

    Funcionario create(FuncionarioDTO dto);

    Funcionario update(Long id, FuncionarioUpdateDTO dto);

    Funcionario updateNomeImagem(Long id, String nomeImagem);

    void updateEnderecoEspecifico(Long id, Long idEndereco, EnderecoDTO dto);

    void updateEndereco(Long id, List<EnderecoDTO> dto);

    void updateTelefoneEspecifico(Long id, Long idTelefone, TelefoneDTO dto);

    void updateTelefone(Long id, List<TelefoneDTO> dto);

    void delete(Long id);

    Funcionario gerarFuncionarioFromCliente(String email);

    void updateSenha(String email, SenhaPatchDTO dto);

    void updateNome(String email, NomePatchDTO dto);

    void updateEmail(String email, EmailPatchDTO dto);

    void updateCpf(String email, CpfPatchDTO dto);

    void updateDataNascimento(String email, DataNascimentoPatchDTO dto);

    List<Funcionario> findByEmail(String email);
    
}
