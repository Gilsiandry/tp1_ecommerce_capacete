package br.unitins.tp1.service.capacete;

import br.unitins.tp1.dto.capacete.CadastroCapaceteDTO;
import br.unitins.tp1.dto.capacete.CapaceteResponseDTO;
import br.unitins.tp1.exception.EntityNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.tp1.repository.CapaceteRepository;
import br.unitins.tp1.repository.ModeloRepository;
import br.unitins.tp1.repository.ViseiraRepository;
import jakarta.persistence.EntityNotFoundException;

        @ApplicationScoped
        public class CapaceteService {

        @Inject
        CapaceteRepository capaceteRepository;

        @Inject
        ModeloRepository modeloRepository;

        @Inject
        loteRepository loteRepository;

        @Inject
        ViseiraRepository viseiraRepository;

        @Transactional
        public CapaceteResponseDTO inserir(CadastroCapaceteDTO dto) {
        Capacete entity = new Capacete();
        entity.setNome(dto.nome());
        entity.setPreco(dto.preco());
        entity.setCategoria(dto.categoria());
        entity.setCor(dto.cor());
        entity.setTamanho(dto.tamanho());
        entity.setJugular(dto.jugular());

        entity.setModelo(modeloRepository.findByIdOptional(dto.idModelo())
                .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado")));

        entity.setLote(loteRepository.findByIdOptional(dto.idLote())
                .orElseThrow(() -> new EntityNotFoundException("Lote não encontrado")));

        entity.setViseira(viseiraRepository.findByIdOptional(dto.idViseira())
                .orElseThrow(() -> new EntityNotFoundException("Viseira não encontrada")));

        capaceteRepository.persist(entity);
        return new CapaceteResponseDTO(entity);
    }

    public List<CapaceteResponseDTO> buscarTodos() {
        return capaceteRepository.listAll().stream()
                .map(CapaceteResponseDTO::new)
                .collect(Collectors.toList());
    }

    public CapaceteResponseDTO buscarPorId(Long id) {
        Capacete capacete = capaceteRepository.findByIdOptional(id)
                .orElseThrow(() -> new EntityNotFoundException("Capacete não encontrado"));
        return new CapaceteResponseDTO(capacete);
    }

    @Transactional
    public CapaceteResponseDTO atualizar(Long id, CadastroCapaceteDTO dto) {
        Capacete capacete = capaceteRepository.findByIdOptional(id)
                .orElseThrow(() -> new EntityNotFoundException("Capacete não encontrado"));

        capacete.setNome(dto.nome());
        capacete.setPreco(dto.preco());
        capacete.setCategoria(dto.categoria());
        capacete.setCor(dto.cor());
        capacete.setTamanho(dto.tamanho());
        capacete.setJugular(dto.jugular());

        capacete.setModelo(modeloRepository.findByIdOptional(dto.idModelo())
                .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado")));

        capacete.setLote(loteRepository.findByIdOptional(dto.idLote())
                .orElseThrow(() -> new EntityNotFoundException("Lote não encontrado")));

        capacete.setViseira(viseiraRepository.findByIdOptional(dto.idViseira())
                .orElseThrow(() -> new EntityNotFoundException("Viseira não encontrada")));

        return new CapaceteResponseDTO(capacete);
    }

    @Transactional
    public void excluir(Long id) {
        Capacete entity = capaceteRepository.findByIdOptional(id)
                .orElseThrow(() -> new EntityNotFoundException("Capacete não encontrado"));
        capaceteRepository.delete(entity);
    }
}

// import java.util.List;

// import br.unitins.tp1.dto.capacete.CapaceteRequestDTO;
// import br.unitins.tp1.model.capacete.Marca;
// import br.unitins.tp1.model.capacete.Capacete;

// public interface CapaceteService {

//     Capacete findById(Long id);

//     List<Capacete> findByNome(String nome);

//     List<Capacete> findBySabor(String sabor);

//     List<Capacete> findByMarca(Marca marca);

//     List<Capacete> findByPreco(Double preco);

//     List<Capacete> findByPrecoMinAndMax(Double precoMin, Double precoMax);
//     List<Capacete> findByMostRated();

//     List<Capacete> findAll();

//     Capacete create(CapaceteRequestDTO dto);

//     void update(Long id, CapaceteRequestDTO dto);

//     void updateNomeImagem(Long id, String nomeImagem);

//     void delete(Long id);
// }