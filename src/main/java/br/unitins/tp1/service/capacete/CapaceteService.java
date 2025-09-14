package br.unitins.tp1.service.capacete;

import java.util.List;

import br.unitins.tp1.dto.capacete.CapaceteRequestDTO;
import br.unitins.tp1.model.capacete.Marca;
import br.unitins.tp1.model.capacete.Capacete;

public interface CapaceteService {

    Capacete findById(Long id);

    List<Capacete> findByNome(String nome);

    List<Capacete> findBySabor(String sabor);

    List<Capacete> findByMarca(Marca marca);

    List<Capacete> findByPreco(Double preco);

    List<Capacete> findByPrecoMinAndMax(Double precoMin, Double precoMax);
    List<Capacete> findByMostRated();

    List<Capacete> findAll();

    Capacete create(CapaceteRequestDTO dto);

    void update(Long id, CapaceteRequestDTO dto);

    void updateNomeImagem(Long id, String nomeImagem);

    void delete(Long id);
}