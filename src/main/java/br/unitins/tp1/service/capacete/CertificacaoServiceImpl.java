package br.unitins.tp1.service.capacete;

import java.util.List;

import br.unitins.tp1.dto.CertificacaoDTO;
import br.unitins.tp1.dto.CertificacaoResponseDTO;
import br.unitins.tp1.model.Certificacao;
import br.unitins.tp1.repository.CertificacaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CertificacaoServiceImpl implements CertificacaoService {

    @Inject
    CertificacaoRepository certificacaoRepository;

    public CertificacaoServiceImpl() {
    }

    @Override
    @Transactional
    public CertificacaoResponseDTO create(CertificacaoDTO certificacao) {
        Certificacao novoCertificacao = new Certificacao();
        novoCertificacao.setNome(certificacao.nome());
        novoCertificacao.setPais(certificacao.pais());
        novoCertificacao.setDescricao(certificacao.descricao());
       

        // realizando inclusao
        certificacaoRepository.persist(novoCertificacao);

        return CertificacaoResponseDTO.valueOf(novoCertificacao);
    }

    @Override
    @Transactional
    public void update(long id, CertificacaoDTO certificacao) {
        Certificacao edicaoCertificacao = certificacaoRepository.findById(id);

        edicaoCertificacao.setNome(certificacao.nome());
        edicaoCertificacao.setPais(certificacao.pais());
        edicaoCertificacao.setDescricao(certificacao.descricao());
    
    }

    @Override
    @Transactional
    public void delete(long id) {
        certificacaoRepository.deleteById(id);
    }

    @Override
    public CertificacaoResponseDTO findById(long id) {
        return CertificacaoResponseDTO.valueOf(certificacaoRepository.findById(id));
    }

    @Override
    public List<CertificacaoResponseDTO> findByPais(String pais) {
        return certificacaoRepository.findByPais(pais).stream().map(certificacao -> CertificacaoResponseDTO.valueOf(certificacao)).toList();
    }

    @Override
    public List<CertificacaoResponseDTO> findByDescricao(String descricao) {
        return certificacaoRepository.findByDescricao(descricao).stream().map(certificacao -> CertificacaoResponseDTO.valueOf(certificacao)).toList();
    }


    @Override
    public List<CertificacaoResponseDTO> findAll() {
        return certificacaoRepository.findAll().stream().map(p -> CertificacaoResponseDTO.valueOf(p)).toList();
    }
    
}