package br.unitins.tp1.service.capacete;

import br.unitins.tp1.dto.capacete.CadastroModeloDTO;
import br.unitins.tp1.dto.capacete.ModeloResponseDTO;
import br.unitins.tp1.exception.EntityNotFoundException;
import br.unitins.tp1.model.capacete.Modelo;
import br.unitins.tp1.repository.capacete.MarcaRepository;
import br.unitins.tp1.repository.capacete.ModeloRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

    @ApplicationScoped
    public class ModeloService {

    @Inject
    ModeloRepository modeloRepository;

    @Inject
    MarcaRepository marcaRepository;

    @Transactional
    public ModeloResponseDTO inserir(CadastroModeloDTO dto) {
        Modelo modelo = new Modelo();
        modelo.setNome(dto.nome());
        modelo.setMarca(marcaRepository.findByIdOptional(dto.idMarca())
                .orElseThrow(() -> new EntityNotFoundException("Marca não encontrada")));
        modeloRepository.persist(modelo);
        return new ModeloResponseDTO(modelo);
    }

    public List<ModeloResponseDTO> buscarTodos() {
        return modeloRepository.listAll().stream()
                .map(ModeloResponseDTO::new)
                .collect(Collectors.toList());
    }

    public ModeloResponseDTO buscarPorId(Long id) {
        Modelo modelo = modeloRepository.findByIdOptional(id)
                .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado"));
        return new ModeloResponseDTO(modelo);
    }

    @Transactional
    public ModeloResponseDTO atualizar(Long id, CadastroModeloDTO dto) {
        Modelo modelo = modeloRepository.findByIdOptional(id)
                .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado"));
        modelo.setNome(dto.nome());
        modelo.setMarca(marcaRepository.findByIdOptional(dto.idMarca())
                .orElseThrow(() -> new EntityNotFoundException("Marca não encontrada")));
        return new ModeloResponseDTO(modelo);
    }

    @Transactional
    public void excluir(Long id) {
        Modelo modelo = modeloRepository.findByIdOptional(id)
                .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado"));
        modeloRepository.delete(modelo);
    }
}