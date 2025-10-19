// package br.unitins.tp1.service.usuario;

// import java.util.List;

// import br.unitins.tp1.dto.usuario.EmailPatchDTO;
// import br.unitins.tp1.dto.usuario.SenhaPatchDTO;
// import br.unitins.tp1.dto.usuario.UsuarioRequestDTO;
// import br.unitins.tp1.model.usuario.Usuario;

// public interface UsuarioService {

//     Usuario findById(Long id);

//     Usuario create(UsuarioRequestDTO dto);

//     List<Usuario> findAll();

//     Usuario findByUsernameAndSenha(String username, String senha);

//     Usuario findByUsername(String username);

//     void updateEmail(Long id, EmailPatchDTO dto);

//     void updateSenha(Long id, SenhaPatchDTO dto);

// }