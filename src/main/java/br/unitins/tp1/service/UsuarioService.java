package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.UsuarioDTO;
import br.unitins.tp1.dto.UsuarioResponseDTO;

public interface UsuarioService {
    void update(long id, UsuarioDTO usuario);
    void delete(long id);

    UsuarioResponseDTO create(UsuarioDTO usuario);
    UsuarioResponseDTO findById(long id);
    UsuarioResponseDTO findByEmail(String email);
    
    List<UsuarioResponseDTO> findAll();
}