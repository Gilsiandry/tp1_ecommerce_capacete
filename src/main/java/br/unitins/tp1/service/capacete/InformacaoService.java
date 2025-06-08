package br.unitins.tp1.service.capacete;

import java.util.List;

import br.unitins.tp1.dto.InformacaoDTO;
import br.unitins.tp1.dto.InformacaoResponseDTO;

public interface InformacaoService {
    InformacaoResponseDTO create(InformacaoDTO informacao);
    void update(long id, InformacaoDTO informacao);
    void delete(long id);

    InformacaoResponseDTO findById(long id);

    List<InformacaoResponseDTO> findByDescricao(String descricao);
    List<InformacaoResponseDTO> findByAnoLancamento(Integer anoLancamento);
    List<InformacaoResponseDTO> findAll();
}