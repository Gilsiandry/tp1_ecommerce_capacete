package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.JugularDTO;
import br.unitins.tp1.dto.JugularResponseDTO;

public interface JugularService {
    JugularResponseDTO create(JugularDTO jugular);
    void update(long id, JugularDTO jugular);
    void delete(long id);
    JugularResponseDTO findById(long id);
    List<JugularResponseDTO> findByCapacete(Long IdCapacete);
    List<JugularResponseDTO> findBytipoFechamento(String tipoFechamento);
    List<JugularResponseDTO> findAll();
}