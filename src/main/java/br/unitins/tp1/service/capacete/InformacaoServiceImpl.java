package br.unitins.tp1.service.capacete;

import java.util.List;

import br.unitins.tp1.dto.InformacaoDTO;
import br.unitins.tp1.dto.InformacaoResponseDTO;
import br.unitins.tp1.model.Informacao;
import br.unitins.tp1.repository.InformacaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class InformacaoServiceImpl implements InformacaoService {

    @Inject
    InformacaoRepository informacaoRepository;

    public InformacaoServiceImpl() {
    }

    @Override
    @Transactional
    public InformacaoResponseDTO create(InformacaoDTO informacao) {
        Informacao novaInformacao = new Informacao();
        novaInformacao.setDescricao(informacao.descricao());
        novaInformacao.setAnoLancamento(informacao.anoLancamento());
       

        // realizando inclusao
        informacaoRepository.persist(novaInformacao);

        return InformacaoResponseDTO.valueOf(novaInformacao);
    }

    @Override
    @Transactional
    public void update(long id, InformacaoDTO informacao) {
        Informacao edicaoInformacao = informacaoRepository.findById(id);

        edicaoInformacao.setDescricao(informacao.descricao());
        edicaoInformacao.setAnoLancamento(informacao.anoLancamento());
    
    }

    @Override
    @Transactional
    public void delete(long id) {
        informacaoRepository.deleteById(id);
    }

    @Override
    public InformacaoResponseDTO findById(long id) {
        return InformacaoResponseDTO.valueOf(informacaoRepository.findById(id));
    }

    @Override
    public List<InformacaoResponseDTO> findByDescricao(String descricao) {
        return informacaoRepository.findByDescricao(descricao).stream().map(informacao -> InformacaoResponseDTO.valueOf(informacao)).toList();
    }
    
    @Override
    public List<InformacaoResponseDTO> findByAnoLancamento(Integer anoLancamento) {
        return informacaoRepository.findByAnoLancamento(anoLancamento).stream().map(informacao -> InformacaoResponseDTO.valueOf(informacao)).toList();
    }


    @Override
    public List<InformacaoResponseDTO> findAll() {
        return informacaoRepository.findAll().stream().map(p -> InformacaoResponseDTO.valueOf(p)).toList();
    }
}