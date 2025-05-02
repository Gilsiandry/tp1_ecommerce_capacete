package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.UsuarioDTO;
import br.unitins.tp1.dto.UsuarioResponseDTO;
import br.unitins.tp1.mapper.PessoaMapper;
import br.unitins.tp1.model.Usuario;
import br.unitins.tp1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl() {
    }

    @Override
    @Transactional
    public UsuarioResponseDTO create(UsuarioDTO usuario) {
        Usuario novoUsuario = new Usuario();

        novoUsuario.setPessoa(PessoaMapper.toEntity(usuario.pessoa()));
        novoUsuario.setEmail(usuario.email());
        novoUsuario.setSenha(usuario.senha());
        novoUsuario.setPerfil(usuario.perfil());

        // realizando inclusao
        usuarioRepository.persist(novoUsuario);

        return UsuarioResponseDTO.valueOf(novoUsuario);
    }

    @Override
    @Transactional
    public void update(long id, UsuarioDTO usuario) {
        Usuario edicaoUsuario = usuarioRepository.findById(id);

        edicaoUsuario.setEmail(usuario.email());
        edicaoUsuario.setSenha(usuario.senha());  
    
    }

    @Override
    @Transactional
    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioResponseDTO findById(long id) {
        return UsuarioResponseDTO.valueOf(usuarioRepository.findById(id));
    }

    @Override
    public UsuarioResponseDTO findByEmail(String email) {
        return UsuarioResponseDTO.valueOf(usuarioRepository.findByEmail(email));
    }


    @Override
    public List<UsuarioResponseDTO> findAll() {
        return usuarioRepository.findAll().stream().map(p -> UsuarioResponseDTO.valueOf(p)).toList();
    }
}