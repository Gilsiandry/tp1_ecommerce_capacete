package br.unitins.tp1.service.capacete;

import java.time.LocalDate;
import java.util.List;

import br.unitins.tp1.dto.LoteDTO;
import br.unitins.tp1.dto.LoteResponseDTO;
import br.unitins.tp1.model.Lote;
import br.unitins.tp1.repository.LoteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class LoteServiceImpl implements LoteService {

    @Inject
    LoteRepository loteRepository;

    public LoteServiceImpl() {
    }

    @Override
    @Transactional
    public LoteResponseDTO create(LoteDTO lote) {
        Lote novoLote = new Lote();
        novoLote.setCodigo(lote.codigo());
        novoLote.setDataFabricacao(lote.dataFabricacao());
       

        // realizando inclusao
        loteRepository.persist(novoLote);

        return LoteResponseDTO.valueOf(novoLote);
    }

    @Override
    @Transactional
    public void update(long id, LoteDTO lote) {
        Lote edicaoLote = loteRepository.findById(id);

        edicaoLote.setCodigo(lote.codigo());
        edicaoLote.setDataFabricacao(lote.dataFabricacao());
    
    }

    @Override
    @Transactional
    public void delete(long id) {
        loteRepository.deleteById(id);
    }

    @Override
    public LoteResponseDTO findById(long id) {
        return LoteResponseDTO.valueOf(loteRepository.findById(id));
    }

    @Override
    public List<LoteResponseDTO> findByCodigo(String codigo) {
        return loteRepository.findByCodigo(codigo).stream().map(lote -> LoteResponseDTO.valueOf(lote)).toList();
    }


    @Override
    public List<LoteResponseDTO> findByDataFabricacao(LocalDate dataFabricacao) {
        return loteRepository.findByDataFabricacao(dataFabricacao).stream().map(lote -> LoteResponseDTO.valueOf(lote)).toList();
    }


    @Override
    public List<LoteResponseDTO> findAll() {
        return loteRepository.findAll().stream().map(p -> LoteResponseDTO.valueOf(p)).toList();
    }
    
}