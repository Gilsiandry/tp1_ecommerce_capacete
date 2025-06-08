package br.unitins.tp1.service.pedido;

import java.util.List;

import br.unitins.tp1.dto.pedido.EstoqueDTO;
import br.unitins.tp1.model.pedido.Estoque;
import br.unitins.tp1.repository.EstoqueRepository;
import br.unitins.tp1.service.capacete.CapaceteService;
import br.unitins.tp1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EstoqueServiceImpl implements EstoqueService {

    @Inject
    public EstoqueRepository loteRepository;

    @Inject
    public CapaceteService capaceteService;

    @Override
    public Estoque findById(Long id) {
        if (loteRepository.findById(id) == null)
            throw new ValidationException("id", "id nao encontrado");
        
        return loteRepository.findById(id);
    }

    @Override
    public Estoque findByIdCapacete(Long idCapacete) {
        if (loteRepository.findByIdCapacete(idCapacete) == null)
            throw new ValidationException("idCapacete", "id do capacete nao encontrado.");

        return loteRepository.findByIdCapacete(idCapacete);
    }

    @Override
    public List<Estoque> findByIdCapaceteQtdeTotal(Long idCapacete) {
        return loteRepository.findByIdCapaceteQtdeTotal(idCapacete);
    }

    @Override
    public Estoque findByCodigo(String codigo) {
        if (loteRepository.findByCodigo(codigo) == null)
            throw new ValidationException("codigo", "Codigo nao encontrado");
        
        return loteRepository.findByCodigo(codigo);
    } 

    @Override
    public List<Estoque> findAll() {
        return loteRepository.findAll().list();
    }

    @Override
    @Transactional
    public Estoque create(EstoqueDTO dto) {
        if (dto == null)
            throw new ValidationException("dto", "Informe os campos necessarios");
            
        if (loteRepository.findByIdCapacete(dto.idCapacete()) == null)
            throw new ValidationException("idCapacete", "id do capacete nao encontrado.");

        // buscando o estado a partir de um id do lote
        Estoque lote = new Estoque();
        lote.setCapacete(capaceteService.findById(dto.idCapacete()));
        lote.setCodigo(dto.codigo());
        lote.setData(dto.data());
        lote.setEstoque(dto.estoque());

        // salvando o lote
        loteRepository.persist(lote);

        return lote;
    }

    @Override
    @Transactional
    public Estoque update(Long id, EstoqueDTO dto) {
        if (loteRepository.findById(id) == null)
            throw new ValidationException("id", "id nao encontrado");

        if (loteRepository.findByIdCapacete(dto.idCapacete()) == null)
            throw new ValidationException("idCapacete", "id do capacete nao encontrado.");

        Estoque lote = loteRepository.findById(id);

        lote.setCapacete(capaceteService.findById(dto.idCapacete()));
        lote.setCodigo(dto.codigo());
        lote.setData(dto.data());
        lote.setEstoque(dto.estoque());
        
        return lote;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (loteRepository.findById(id) == null)
            throw new ValidationException("id", "id nao encontrado");
            
        loteRepository.deleteById(id);
    }
    
}
