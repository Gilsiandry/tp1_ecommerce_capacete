package br.unitins.tp1.service.capacete;

import java.util.List;

import br.unitins.tp1.dto.capacete.MarcaRequestDTO;
import br.unitins.tp1.model.capacete.Marca;
import br.unitins.tp1.repository.capacete.MarcaRepository;
import br.unitins.tp1.validation.EntidadeNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

    @ApplicationScoped
    public class MarcaServiceImpl implements MarcaService {

    @Inject
    public MarcaRepository saborRepository;

    @Override
    public Marca findById(Long id) {
        Marca sabor = saborRepository.findById(id);
        if (sabor == null)
            throw new EntidadeNotFoundException("id", "Marca não encontrado!");

        return sabor;

    }

    @Override
    public List<Marca> findByNome(String nome) {
        return saborRepository.findByNome(nome);
    }

    @Override
    public List<Marca> findAll() {
        return saborRepository.listAll();
    }

    @Override
    @Transactional
    public Marca create(MarcaRequestDTO dto) {
        Marca sabor = new Marca();
        sabor.setNome(dto.nome());
        saborRepository.persist(sabor);
        return sabor;
    }

    @Override
    @Transactional
    public void update(Long id, MarcaRequestDTO dto) {
        Marca sabor = saborRepository.findById(id);
        if (sabor == null)
            throw new EntidadeNotFoundException("id", "Marca não encontrado!");

        sabor.setNome(dto.nome());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Marca sabor = saborRepository.findById(id);
        if (sabor == null)
            throw new EntidadeNotFoundException("id", "Marca não encontrado!");
        saborRepository.delete(sabor);
    }

}