package br.unitins.tp1.service.usuario;

import java.util.List;

import br.unitins.tp1.dto.TelefoneDTO;
import br.unitins.tp1.dto.endereco.EnderecoDTO;
import br.unitins.tp1.dto.usuario.ClienteBasicoDTO;
import br.unitins.tp1.dto.usuario.ClienteDTO;
import br.unitins.tp1.dto.usuario.ClienteUpdateDTO;
import br.unitins.tp1.dto.usuario.patches.CpfPatchDTO;
import br.unitins.tp1.dto.usuario.patches.DataNascimentoPatchDTO;
import br.unitins.tp1.dto.usuario.patches.EmailPatchDTO;
import br.unitins.tp1.dto.usuario.patches.NomePatchDTO;
import br.unitins.tp1.dto.usuario.patches.SenhaPatchDTO;
import br.unitins.tp1.model.capacete.Capacete;
import br.unitins.tp1.model.usuario.Cliente;

public interface ClienteService {

    Cliente findById(Long id);
    
    List<Cliente> findByNome(String nome);
    
    Cliente findByUsuario (String email);
    
    List<Cliente> findAll();
    
    Cliente create(ClienteDTO dto);
    
    void delete(Long id);

    List<Cliente> findByEmail(String email);
    
    void adicionarProdutoListaDesejo(String email, Long idProduto);
    
    void removerProdutoListaDesejo(String email, Long idProduto);
    
    List<Capacete> getListaDesejos(String email);
    
    Cliente createClienteBasico(ClienteBasicoDTO dto);
    
    // metodos para o cliente utilizar
    Cliente getMinhasInformacoess(String email);
    Cliente update(String email, ClienteUpdateDTO dto);
    void updateSenha(String email, SenhaPatchDTO dto);
    void updateNome(String email, NomePatchDTO dto);
    void updateEmail(String email, EmailPatchDTO dto);
    void updateEnderecoEspecifico(String email, Long idEndereco, EnderecoDTO dto);
    void updateEndereco(String email, List<EnderecoRequestDTO> dto);
    void updateTelefoneEspecifico(String email, Long idTelefone, TelefoneDTO dto);
    void updateTelefone(String email, List<TelefoneDTO> dto);
    Cliente updateNomeImagem(String email, String nomeImagem);
    Cliente gerarClienteFromFuncionario(String email);
    void updateCpf(String email, CpfPatchDTO dto);
    void updateDataNascimento(String email, DataNascimentoPatchDTO dto);
}
