package br.unitins.tp1.service.capacete;

import br.unitins.tp1.dto.capacete.CadastroMarcaDTO;
import br.unitins.tp1.dto.capacete.MarcaResponseDTO;
import br.unitins.tp1.exception.EntityNotFoundException;
import br.unitins.tp1.model.capacete.Marca;
import br.unitins.tp1.repository.capacete.FabricanteRepository;
import br.unitins.tp1.repository.capacete.MarcaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

    @ApplicationScoped
    public class MarcaService {

    @Inject
    MarcaRepository marcaRepository;

    @Inject
    FabricanteRepository fabricanteRepository;

    @Transactional
    public MarcaResponseDTO inserir(CadastroMarcaDTO dto) {
        Marca marca = new Marca();
        marca.setNome(dto.nome());
        marca.setFabricante(fabricanteRepository.findByIdOptional(dto.idFabricante())
                .orElseThrow(() -> new EntityNotFoundException("Fabricante não encontrado")));
        marcaRepository.persist(marca);
        return new MarcaResponseDTO(marca);
    }

    public List<MarcaResponseDTO> buscarTodos() {
        return marcaRepository.listAll().stream()
                .map(MarcaResponseDTO::new)
                .collect(Collectors.toList());
    }

    public MarcaResponseDTO buscarPorId(Long id) {
        Marca marca = marcaRepository.findByIdOptional(id)
                .orElseThrow(() -> new EntityNotFoundException("Marca não encontrada"));
        return new MarcaResponseDTO(marca);
    }

    @Transactional
    public MarcaResponseDTO atualizar(Long id, CadastroMarcaDTO dto) {
        Marca marca = marcaRepository.findByIdOptional(id)
                .orElseThrow(() -> new EntityNotFoundException("Marca não encontrada"));
        marca.setNome(dto.nome());
        marca.setFabricante(fabricanteRepository.findByIdOptional(dto.idFabricante())
                .orElseThrow(() -> new EntityNotFoundException("Fabricante não encontrado")));
        return new MarcaResponseDTO(marca);
    }

    @Transactional
    public void excluir(Long id) {
        Marca marca = marcaRepository.findByIdOptional(id)
                .orElseThrow(() -> new EntityNotFoundException("Marca não encontrada"));
        marcaRepository.delete(marca);
    }
}

// import java.util.List;

// import br.unitins.tp1.dto.capacete.MarcaRequestDTO;
// import br.unitins.tp1.model.capacete.Marca;

// public interface MarcaService {

//     Marca findById(Long id);

//     List<Marca> findByNome(String nome);

//     List<Marca> findAll();

//     Marca create(MarcaRequestDTO dto);

//     void update(Long id, MarcaRequestDTO dto);

//     void delete(Long id);

// }