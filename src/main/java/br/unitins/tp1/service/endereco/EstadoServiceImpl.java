package br.unitins.tp1.service.endereco;

import java.util.List;

import br.unitins.tp1.dto.endereco.EstadoDTO;
import br.unitins.tp1.model.endereco.Estado;
import br.unitins.tp1.repository.EstadoRepository;
import br.unitins.tp1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EstadoServiceImpl implements EstadoService {

    @Inject
    public EstadoRepository estadoRepository;

    @Override
    public Estado findById(Long id) {
        if (estadoRepository.findById(id) == null)
            throw new ValidationException("id", "Id nao encontrado");
        return estadoRepository.findById(id);
    }

    @Override
    public List<Estado> findByNome(String nome) {
        return estadoRepository.findByNome(nome);
    }

    @Override
    public List<Estado> findAll() {
        return estadoRepository.findAll().list();
    }

    @Override
    @Transactional
    public Estado create(EstadoDTO dto) {
        Estado estado = new Estado();
        estado.setNome(dto.nome());
        estado.setSigla(dto.sigla());

        estadoRepository.persist(estado);
        return estado;
    }

    @Override
    @Transactional
    public Estado update(Long id, EstadoDTO dto) {
        if (estadoRepository.findById(id) == null)
            throw new ValidationException("id", "Id nao encontrado");
            
        Estado estado = estadoRepository.findById(id);
        
        estado.setNome(dto.nome());
        estado.setSigla(dto.sigla());
        
        return estado;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        estadoRepository.deleteById(id);
    }
    
}
