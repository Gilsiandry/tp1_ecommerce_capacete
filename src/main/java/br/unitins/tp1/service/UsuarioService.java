package br.unitins.tp1.service;


import java.util.List;

import br.unitins.tp1.dto.usuario.UsuarioDTO;
import br.unitins.tp1.model.Usuario;

public interface UsuarioService {
    UsuarioResponseDTO create(UsuarioDTO usuario);
    void update(long id, JugularDTO usuario);
    void delete(Long id);
    UsuarioResponseDTO findById(long id);

    Usuario findByEmail(String email);
    List<JugularResponseDTO> findByEmail(String email);
    List<JugularResponseDTO> findAll();
    
    

}