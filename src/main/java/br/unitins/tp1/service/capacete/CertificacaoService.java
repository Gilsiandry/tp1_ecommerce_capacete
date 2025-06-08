package br.unitins.tp1.service.capacete;

import java.util.List;

import br.unitins.tp1.dto.CertificacaoDTO;
import br.unitins.tp1.dto.CertificacaoResponseDTO;

public interface CertificacaoService {
    CertificacaoResponseDTO create(CertificacaoDTO certificacao);
    void update(long id, CertificacaoDTO certificacao);
    void delete(long id);

    CertificacaoResponseDTO findById(long id);

    List<CertificacaoResponseDTO> findByPais(String pais);
    List<CertificacaoResponseDTO> findByDescricao(String descricao);
    List<CertificacaoResponseDTO> findAll();
}