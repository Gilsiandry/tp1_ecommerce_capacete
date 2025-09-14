package br.unitins.tp1.service.lote;

import java.util.List;

import br.unitins.tp1.dto.lote.LoteRequestDTO;
import br.unitins.tp1.model.pedido.Lote;
import br.unitins.tp1.repository.LoteRepository;
import br.unitins.tp1.service.capacete.CapaceteService;
import br.unitins.tp1.validation.EntidadeNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class LoteServiceImpl implements LoteService {

    @Inject
    public LoteRepository loteRepository;

    @Inject
    public CapaceteService capaceteService;

    @Override
    public Lote findById(Long id) {
        Lote lote = loteRepository.findById(id);

        if (lote == null) {
            throw new EntidadeNotFoundException("id", "Lote não encontrado");
        }
        return lote;

    }

    @Override
    public List<Lote> findAll() {
        return loteRepository.listAll();
    }

    @Override
    @Transactional
    public Lote create(LoteRequestDTO dto) {
        Lote lote = new Lote();
        lote.setCodigo(dto.codigo());
        lote.setDataFabricacao(dto.dataFabricacao());
        lote.setQuantidade(dto.quantidade());
        lote.setCapacete(capaceteService.findById(dto.idCapacete()));
        loteRepository.persist(lote);
        return lote;
    }

    @Override
    @Transactional
    public void update(Long id, LoteRequestDTO dto) {
        Lote lote = loteRepository.findById(id);
        if (lote == null)
            throw new EntidadeNotFoundException("id", "Lote não encontrado!");

        lote.setCodigo(dto.codigo());
        lote.setDataFabricacao(dto.dataFabricacao());
        lote.setQuantidade(dto.quantidade());
        lote.setCapacete(capaceteService.findById(dto.idCapacete()));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Lote lote = loteRepository.findById(id);
        if (lote == null)
            throw new EntidadeNotFoundException("id", "Lote não encontrado!");
        loteRepository.delete(lote);
    }

    @Override
    public Lote findByCodigo(String codigo) {
        return loteRepository.findByCodigo(codigo);
    }

    @Override
    public Lote findByCapacete(Long idCapacete) {
        return loteRepository.findByCapacete(idCapacete);
    }

    @Override
    public Integer findByIdCapaceteQuantidadeTotal(Long idCapacete) {
        return loteRepository.findByIdCapaceteQuantidadeTotal(idCapacete);
    }

}