package br.unitins.tp1.service.capacete;

import java.util.List;

import br.unitins.tp1.dto.JugularDTO;
import br.unitins.tp1.dto.JugularResponseDTO;
import br.unitins.tp1.model.Jugular;
import br.unitins.tp1.repository.JugularRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class JugularServiceImpl implements JugularService {

    @Inject
    JugularRepository jugularRepository;

    /*@Inject
    CapaceteRepository capaceteRepository;*/

    @Override
    @Transactional
    public JugularResponseDTO create(JugularDTO dto) {
        Jugular novaJugular = new Jugular();
        novaJugular.setTipoFechamento(dto.tipoFechamento());

        // buscando o capacete pelo id
        /*Capacete capacete = capaceteRepository.findById(dto.idCapacete());

        novaJugular.setCapacete(capacete);*/

        // realizando inclusao
        jugularRepository.persist(novaJugular);

        return JugularResponseDTO.valueOf(novaJugular);
    }

    @Override
    @Transactional
    public void update(long id, JugularDTO dto) {
        Jugular edicaoJugular = jugularRepository.findById(id);
        edicaoJugular.setTipoFechamento(dto.tipoFechamento());
        // buscando o capacete pelo id
        /*Capacete capacete = capaceteRepository.findById(dto.idCapacete());
        edicaoJugular.setCapacete(capacete);*/
    }

    @Override
    @Transactional
    public void delete(long id) {
        jugularRepository.deleteById(id);
    }

    @Override
    public JugularResponseDTO findById(long id) {
        return JugularResponseDTO.valueOf(jugularRepository.findById(id));
    }

    /*@Override
    public List<JugularResponseDTO> findByCapacete(Long idCapacete) {
        return jugularRepository.findByCapacete(idCapacete)
        .stream().map(m -> JugularResponseDTO.valueOf(m)).toList();
    }*/

    @Override
    public List<JugularResponseDTO> findByTipoFechamento(String tipoFechamento) {
        return jugularRepository.findByTipoFechamento(tipoFechamento)
        .stream().map(m -> JugularResponseDTO.valueOf(m)).toList();
    }

    @Override
    public List<JugularResponseDTO> findAll() {
        return jugularRepository.findAll().stream().map(m-> JugularResponseDTO.valueOf(m)).toList();
    }
}