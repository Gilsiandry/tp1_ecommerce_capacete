package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.ProdutoDTO;
import br.unitins.tp1.dto.ProdutoResponseDTO;

public interface ProdutoService {

    ProdutoResponseDTO create(ProdutoDTO produto);
    void update(long id, ProdutoDTO produto);
    void delete(long id);
    ProdutoResponseDTO findById(long id);
    ProdutoResponseDTO findByMarca(String marca);
    ProdutoResponseDTO findByModelo(String modelo);
    ProdutoResponseDTO findByCor(String cor);
    ProdutoResponseDTO findByTamanho(String tamanho);
    //ProdutoResponseDTO findByPreco(String preco);
    List<ProdutoResponseDTO> findAll();
    
}