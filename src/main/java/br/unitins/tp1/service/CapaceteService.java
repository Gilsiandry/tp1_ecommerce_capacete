package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.CapaceteDTO;
import br.unitins.tp1.dto.CapaceteResponseDTO;

public interface CapaceteService {
    CapaceteResponseDTO create(CapaceteDTO capacete);
    void update(long id, CapaceteDTO capacete);
    void delete(long id);
    CapaceteResponseDTO findById(long id);
    List<CapaceteResponseDTO> findByMarca(String marca);
     List<CapaceteResponseDTO> findByCategoria(String categoria);
    List<CapaceteResponseDTO> findByModelo(String modelo);
    List<CapaceteResponseDTO> findByCor(String cor);
    List<CapaceteResponseDTO> findByTamanho(int tamanho);
    //List<CapaceteResponseDTO> findByPreco(Double preco);
    List<CapaceteResponseDTO> findAll();
}