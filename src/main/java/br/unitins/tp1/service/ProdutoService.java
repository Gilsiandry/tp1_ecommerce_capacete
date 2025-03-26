package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.ProdutoDTO;
import br.unitins.tp1.dto.ProdutoResponseDTO;

public interface ProdutoService {
    ProdutoResponseDTO create(ProdutoDTO produto);
    void update(long id, ProdutoDTO produto);
    void delete(long id);
    ProdutoResponseDTO findById(long id);
    List<ProdutoResponseDTO> findByMarca(String marca);
    List<ProdutoResponseDTO> findByModelo(String modelo);
    List<ProdutoResponseDTO> findByCor(String cor);
    List<ProdutoResponseDTO> findByTamanho(int tamanho);
    //List<ProdutoResponseDTO> findByPreco(Double preco);
    List<ProdutoResponseDTO> findAll();
}