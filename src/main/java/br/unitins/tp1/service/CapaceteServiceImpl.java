package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.CapaceteDTO;
import br.unitins.tp1.dto.CapaceteResponseDTO;
import br.unitins.tp1.model.Capacete;
import br.unitins.tp1.repository.CapaceteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CapaceteServiceImpl implements CapaceteService {

    @Inject
    CapaceteRepository capaceteRepository;

    public CapaceteServiceImpl() {
    }

    @Override
    @Transactional
    public CapaceteResponseDTO create(CapaceteDTO capacete) {
        Capacete novoCapacete = new Capacete();
        novoCapacete.setNome(capacete.nome());
        novoCapacete.setMarca(capacete.marca());
        novoCapacete.setCategoria(capacete.categoria());
        novoCapacete.setModelo(capacete.modelo());
        novoCapacete.setCor(capacete.cor());
        novoCapacete.setTamanho(capacete.tamanho());
        //novoCapacete.setPreco(capacete.preco());
       

        // realizando inclusao
        capaceteRepository.persist(novoCapacete);

        return CapaceteResponseDTO.valueOf(novoCapacete);
    }

    @Override
    @Transactional
    public void update(long id, CapaceteDTO capacete) {
        Capacete edicaoCapacete = capaceteRepository.findById(id);

        edicaoCapacete.setNome(capacete.nome());
        edicaoCapacete.setMarca(capacete.marca());
        edicaoCapacete.setCategoria(capacete.categoria());
        edicaoCapacete.setModelo(capacete.modelo());
        edicaoCapacete.setCor(capacete.cor());
        edicaoCapacete.setTamanho(capacete.tamanho());
        edicaoCapacete.setPreco(capacete.preco());
    
    }

    @Override
    @Transactional
    public void delete(long id) {
        capaceteRepository.deleteById(id);
    }

    @Override
    public CapaceteResponseDTO findById(long id) {
        return CapaceteResponseDTO.valueOf(capaceteRepository.findById(id));
    }

    @Override
    public List<CapaceteResponseDTO> findByMarca(String marca) {
        return capaceteRepository.findByMarca(marca).stream().map(capacete -> CapaceteResponseDTO.valueOf(capacete)).toList();
    }

    @Override
    public List<CapaceteResponseDTO> findByCategoria(String categoria) {
        return capaceteRepository.findByCategoria(categoria).stream().map(capacete -> CapaceteResponseDTO.valueOf(capacete)).toList();
    }

    @Override
    public List<CapaceteResponseDTO> findByModelo(String modelo) {
        return capaceteRepository.findByModelo(modelo).stream().map(capacete -> CapaceteResponseDTO.valueOf(capacete)).toList();
    }

    @Override
    public List<CapaceteResponseDTO> findByCor(String cor) {
        return capaceteRepository.findByCor(cor).stream().map(capacete -> CapaceteResponseDTO.valueOf(capacete)).toList();
    }

    @Override
    public List<CapaceteResponseDTO> findByTamanho(int tamanho) {
        return capaceteRepository.findByTamanho(tamanho).stream().map(capacete -> CapaceteResponseDTO.valueOf(capacete)).toList();
    }

    @Override
    public List<CapaceteResponseDTO> findByPreco(Double min, Double max) {
        return capaceteRepository.findByPreco(min, max).stream().map(capacete -> CapaceteResponseDTO.valueOf(capacete)).toList();
    }


    @Override
    public List<CapaceteResponseDTO> findAll() {
        return capaceteRepository.findAll().stream().map(p -> CapaceteResponseDTO.valueOf(p)).toList();
    }
    
}