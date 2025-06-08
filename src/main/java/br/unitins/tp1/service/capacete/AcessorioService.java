package br.unitins.tp1.service.capacete;

import java.util.List;

import br.unitins.tp1.dto.AcessorioDTO;
import br.unitins.tp1.dto.AcessorioResponseDTO;

public interface AcessorioService {
    AcessorioResponseDTO create(AcessorioDTO acessorio);
    void update(long id, AcessorioDTO acessorio);
    void delete(long id);

    AcessorioResponseDTO findById(long id);

    List<AcessorioResponseDTO> findByCor(String cor);
    List<AcessorioResponseDTO> findAll();
}