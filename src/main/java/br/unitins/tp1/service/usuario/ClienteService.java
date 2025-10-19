// package br.unitins.tp1.service.usuario;

// import java.util.List;

// import br.unitins.tp1.dto.endereco.EnderecoRequestDTO;
// import br.unitins.tp1.dto.pessoa.ClienteRequestDTO;
// import br.unitins.tp1.dto.pessoa.ClienteUpdateRequestDTO;
// import br.unitins.tp1.dto.telefone.TelefoneRequestDTO;
// import br.unitins.tp1.model.endereco.Endereco;
// import br.unitins.tp1.model.usuario.Cliente;
// import br.unitins.tp1.model.usuario.Telefone;
// import br.unitins.tp1.model.capacete.Capacete;

// public interface ClienteService {

//     Cliente findById(Long id);

//     List<Cliente> findByNome(String nome);

//     Cliente findByUsuario(String username);

//     List<Cliente> findAll();

//     Cliente create(String username, ClienteRequestDTO dto);

//     void update(String username, ClienteUpdateRequestDTO dto);

//     void delete(Long id);

//     void updateTelefone(String username, Long idTelefone, TelefoneRequestDTO dto);

//     Telefone addTelefone(String username, TelefoneRequestDTO dto);

//     void updateEndereco(String username, Long idEndereco, EnderecoRequestDTO dto);

//     Endereco addEndereco(String username, EnderecoRequestDTO dto);

//     void updateNomeImagem(String username, String nomeImagem);

//     void adicionarListaDesejo(String username, Long idProduto);

//     void removerListaDesejo(String username, Long idProduto);

//     List<Capacete> getListaDesejos(String username);

//     boolean existsByPessoaFisica(Long idPessoaFisica);

// }