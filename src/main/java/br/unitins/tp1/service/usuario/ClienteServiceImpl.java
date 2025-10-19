// package br.unitins.tp1.service.usuario;

// import java.util.ArrayList;
// import java.util.List;

// import br.unitins.tp1.dto.endereco.EnderecoRequestDTO;
// import br.unitins.tp1.dto.pessoa.ClienteRequestDTO;
// import br.unitins.tp1.dto.pessoa.ClienteUpdateRequestDTO;
// import br.unitins.tp1.dto.telefone.TelefoneRequestDTO;
// import br.unitins.tp1.model.endereco.Endereco;
// import br.unitins.tp1.model.usuario.Cliente;
// import br.unitins.tp1.model.usuario.Perfil;
// import br.unitins.tp1.model.usuario.PessoaFisica;
// import br.unitins.tp1.model.usuario.Telefone;
// import br.unitins.tp1.model.usuario.Usuario;
// import br.unitins.tp1.model.capacete.Capacete;
// import br.unitins.tp1.repository.ClienteRepository;
// import br.unitins.tp1.repository.PessoaFisicaRepository;
// import br.unitins.tp1.service.hash.HashService;
// import br.unitins.tp1.service.capacete.CapaceteService;
// import br.unitins.tp1.service.endereco.CidadeService;
// import br.unitins.tp1.validation.EntidadeNotFoundException;
// import br.unitins.tp1.validation.ValidationException;
// import jakarta.enterprise.context.ApplicationScoped;
// import jakarta.inject.Inject;
// import jakarta.transaction.Transactional;

// @ApplicationScoped
// public class ClienteServiceImpl implements ClienteService {

//     @Inject
//     public ClienteRepository clienteRepository;

//     @Inject
//     public PessoaFisicaRepository pessoaFisicaRepository;

//     @Inject
//     public UsuarioService usuarioService;

//     @Inject
//     public CidadeService cidadeService;

//     @Inject
//     public CapaceteService capaceteService;

//     @Inject
//     public HashService hashService;

//     @Override
//     public Cliente findById(Long id) {
//         Cliente cliente = clienteRepository.findById(id);

//         if (cliente == null) {
//             throw new EntidadeNotFoundException("id", "Cliente não encontrado");
//         }
//         return cliente;

//     }

//     @Override
//     public List<Cliente> findByNome(String nome) {
//         return clienteRepository.findClienteByNome(nome);
//     }

//     @Override
//     public List<Cliente> findAll() {
//         return clienteRepository.listAll();
//     }

//     @Override
//     @Transactional
//     public Cliente create(String username, ClienteRequestDTO dto) {
//         validarEntidade(dto);

//         Cliente cliente = new Cliente();
//         PessoaFisica pf = new PessoaFisica();
//         Usuario usuario = usuarioService.findByUsername(username);
//         usuario.getListaPerfil().add(Perfil.CLIENTE);

//         pf.setUsuario(usuario); // Associando pessoa com usuario

//         // Defenindo pessoa fisica
//         pf.setNome(dto.nome());
//         pf.setEmail(usuario.getEmail());
//         pf.setCpf(dto.cpf());
//         pf.setDataNascimento(dto.dataNascimento());
//         pf.setEnderecos(getEnderecos(dto));
//         pf.setTelefones(getTelefones(dto));

//         pessoaFisicaRepository.persist(pf);
//         cliente.setPessoaFisica(pf); // Associando cliente com pf
//         clienteRepository.persist(cliente);

//         return cliente;
//     }

//     @Override
//     @Transactional
//     public void update(String username, ClienteUpdateRequestDTO dto) {
//         Cliente cliente = clienteRepository.findClienteByUsername(username);

//         if (cliente == null)
//             throw new EntidadeNotFoundException("id", "Cliente não encontrado");

//         if (existeCPF(dto.cpf())) {
//             throw new ValidationException("cpf", "CPF informado é inválido");
//         }

//         PessoaFisica pf = cliente.getPessoaFisica();
//         pf.setNome(dto.nome());
//         pf.setCpf(dto.cpf());
//         pf.setDataNascimento(dto.dataNascimento());
//     }

//     @Override
//     public boolean existsByPessoaFisica(Long idPessoaFisica) {
//         return clienteRepository.existsByPessoaFisica(idPessoaFisica) != null;
//     }

//     @Override
//     @Transactional
//     public void delete(Long clienteId) {

//         Cliente cliente = clienteRepository.findById(clienteId);
//         if (cliente == null) {
//             throw new EntidadeNotFoundException("clienteId", "Cliente não encontrado");
//         }
//         clienteRepository.delete(cliente);
//     }

//     @Override
//     @Transactional
//     public void updateTelefone(String username, Long idTelefone, TelefoneRequestDTO dto) {
//         Cliente cliente = clienteRepository.findClienteByUsername(username);

//         if (cliente == null) {
//             throw new EntidadeNotFoundException("id", "Cliente não encontrado");
//         }
//         Telefone telefone = cliente.getPessoaFisica().getTelefones().stream().filter(t -> t.getId().equals(idTelefone))
//                 .findFirst()
//                 .orElseThrow(() -> new EntidadeNotFoundException("idTelefone", "Telefone não encontrado"));

//         telefone.setCodigoArea(dto.codigoArea());
//         telefone.setNumero(dto.numero());
//     }

//     @Override
//     @Transactional
//     public void updateEndereco(String username, Long idEndereco, EnderecoRequestDTO dto) {
//         Cliente cliente = clienteRepository.findClienteByUsername(username);

//         if (cliente == null) {
//             throw new EntidadeNotFoundException("id", "Cliente não encontrado");
//         }
//         Endereco endereco = cliente.getPessoaFisica().getEnderecos().stream().filter(e -> e.getId().equals(idEndereco))
//                 .findFirst()
//                 .orElseThrow(() -> new EntidadeNotFoundException("idEndereco", "Endereco não encontrado"));

//         endereco.setBairro(dto.bairro());
//         endereco.setCep(dto.cep());
//         endereco.setComplemento(dto.complemento());
//         endereco.setLogradouro(dto.logradouro());
//         endereco.setNumero(dto.numero());
//         endereco.setCidade(cidadeService.findById(dto.idCidade()));

//         cliente.getPessoaFisica().setEnderecos(cliente.getPessoaFisica().getEnderecos());

//     }

//     private List<Telefone> getTelefones(ClienteRequestDTO dto) {
//         List<Telefone> telefones = new ArrayList<>();

//         for (int i = 0; i < dto.telefones().size(); i++) {
//             Telefone telefone = new Telefone();
//             TelefoneRequestDTO telefoneRequestDTO = dto.telefones().get(i);
//             telefone.setCodigoArea(telefoneRequestDTO.codigoArea());
//             telefone.setNumero(telefoneRequestDTO.numero());
//             telefones.add(telefone);
//         }
//         return telefones;
//     }

//     private List<Endereco> getEnderecos(ClienteRequestDTO dto) {
//         List<Endereco> enderecos = new ArrayList<>();

//         for (int i = 0; i < dto.enderecos().size(); i++) {
//             Endereco endereco = new Endereco();
//             EnderecoRequestDTO enderecoRequestDTO = dto.enderecos().get(i);
//             endereco.setBairro(enderecoRequestDTO.bairro());
//             endereco.setCep(enderecoRequestDTO.cep());
//             endereco.setComplemento(enderecoRequestDTO.complemento());
//             endereco.setLogradouro(enderecoRequestDTO.logradouro());
//             endereco.setNumero(enderecoRequestDTO.numero());
//             endereco.setCidade(cidadeService.findById(enderecoRequestDTO.idCidade()));
//             enderecos.add(endereco);
//         }
//         return enderecos;
//     }

//     @Override
//     public Cliente findByUsuario(String username) {
//         return clienteRepository.findClienteByUsername(username);
//     }

//     @Override
//     @Transactional
//     public void updateNomeImagem(String username, String nomeImagem) {
//         Cliente cliente = clienteRepository.findClienteByUsername(username);
//         cliente.getPessoaFisica().setFotoPerfil(nomeImagem);
//     }

//     @Override
//     @Transactional
//     public void adicionarListaDesejo(String username, Long idCapacete) {
//         Cliente cliente = clienteRepository.findClienteByUsername(username);

//         if (cliente.getListaDesejos() == null) {
//             cliente.setListaDesejos(new ArrayList<>());
//             return;
//         }

//         Capacete capacete = capaceteService.findById(idCapacete);
//         if (capacete == null) {
//             throw new EntidadeNotFoundException("idCapacete", "Capacete não encontrado");
//         }
//         cliente.getListaDesejos().add(capacete);
//     }

//     @Override
//     @Transactional
//     public void removerListaDesejo(String username, Long idCapacete) {
//         Cliente cliente = clienteRepository.findClienteByUsername(username);
//         List<Capacete> listaDesejos = cliente.getListaDesejos();

//         if (listaDesejos == null) {
//             throw new EntidadeNotFoundException("message", "Caro cliente, voce ainda não possui uma lista de desejos");
//         }

//         Capacete capacete = capaceteService.findById(idCapacete);
//         if (capacete == null) {
//             throw new EntidadeNotFoundException("idCapacete", "Capacete não encontrado");
//         }

//         if (!listaDesejos.contains(capacete)) {
//             throw new EntidadeNotFoundException("idCapacete", "O produto não está na lista de desejo");
//         }

//         listaDesejos.remove(capacete);
//     }

//     @Override
//     public List<Capacete> getListaDesejos(String username) {
//         Cliente cliente = clienteRepository.findClienteByUsername(username);
//         return cliente.getListaDesejos();
//     }

//     private void validarEntidade(ClienteRequestDTO dto) {

//         if (existeCPF(dto.cpf())) {
//             throw new ValidationException("cpf", "Cpf informado é inválido");
//         }

//     }

//     private boolean existeCPF(String cpf) {
//         return clienteRepository.findClienteByCpf(cpf) == null ? false : true;
//     }

//     @Override
//     @Transactional
//     public Telefone addTelefone(String username, TelefoneRequestDTO dto) {
//         Cliente cliente = clienteRepository.findClienteByUsername(username);
//         Telefone telefone = new Telefone();
//         telefone.setCodigoArea(dto.codigoArea());
//         telefone.setNumero(dto.numero());
//         cliente.getPessoaFisica().getTelefones().add(telefone);
//         return telefone;
//     }

//     @Override
//     @Transactional
//     public Endereco addEndereco(String username, EnderecoRequestDTO dto) {
//         Cliente cliente = clienteRepository.findClienteByUsername(username);
//         Endereco endereco = new Endereco();
//         endereco.setBairro(dto.bairro());
//         endereco.setCep(dto.cep());
//         endereco.setComplemento(dto.complemento());
//         endereco.setLogradouro(dto.logradouro());
//         endereco.setNumero(dto.numero());
//         endereco.setCidade(cidadeService.findById(dto.idCidade()));

//         cliente.getPessoaFisica().getEnderecos().add(endereco);
//         return endereco;
//     }

// }
