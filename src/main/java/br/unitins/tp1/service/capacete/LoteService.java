package br.unitins.tp1.service.capacete;

import java.util.List;

import br.unitins.tp1.dto.LoteDTO;
import br.unitins.tp1.dto.LoteResponseDTO;
import java.time.LocalDate;

public interface LoteService {
    LoteResponseDTO create(LoteDTO lote);
    void update(long id, LoteDTO lote);
    void delete(long id);

    LoteResponseDTO findById(long id);

    List<LoteResponseDTO> findByCodigo(String codigo);
    List<LoteResponseDTO> findByDataFabricacao(LocalDate datafabricacao);
    List<LoteResponseDTO> findAll();
}