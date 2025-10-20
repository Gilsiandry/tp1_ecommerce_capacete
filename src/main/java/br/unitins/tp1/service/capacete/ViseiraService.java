package br.unitins.tp1.service.capacete;

import br.unitins.tp1.dto.capacete.CadastroViseiraDTO;
import br.unitins.tp1.dto.capacete.ViseiraResponseDTO;
import br.unitins.tp1.exception.EntityNotFoundException;
import br.unitins.tp1.model.capacete.Viseira;
import br.unitins.tp1.repository.CorViseiraRepository;
import br.unitins.tp1.repository.capacete.MarcaRepository;
import br.unitins.tp1.repository.capacete.ViseiraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

        @ApplicationScoped
        public class ViseiraService {

         @Inject
         ViseiraRepository viseiraRepository;

        @Inject
        MarcaRepository marcaRepository;

        @Inject
        CorViseiraRepository corViseiraRepository;

        @Transactional
        public ViseiraResponseDTO inserir(CadastroViseiraDTO dto) {
        Viseira viseira = new Viseira();
        viseira.setMarca(marcaRepository.findByIdOptional(dto.idMarca())
                .orElseThrow(() -> new EntityNotFoundException("Marca não encontrada")));
        viseira.setCor(corViseiraRepository.findByIdOptional(dto.idCorViseira())
                .orElseThrow(() -> new EntityNotFoundException("Cor da viseira não encontrada")));
        viseira.setTipo(dto.tipo());
        viseiraRepository.persist(viseira);
        return new ViseiraResponseDTO(viseira);
    }

    public List<ViseiraResponseDTO> buscarTodos() {
        return viseiraRepository.listAll().stream()
                .map(ViseiraResponseDTO::new)
                .collect(Collectors.toList());
    }

    public ViseiraResponseDTO buscarPorId(Long id) {
        Viseira viseira = viseiraRepository.findByIdOptional(id)
                .orElseThrow(() -> new EntityNotFoundException("Viseira não encontrada"));
        return new ViseiraResponseDTO(viseira);
    }

    @Transactional
    public ViseiraResponseDTO atualizar(Long id, CadastroViseiraDTO dto) {
        Viseira viseira = viseiraRepository.findByIdOptional(id)
                .orElseThrow(() -> new EntityNotFoundException("Viseira não encontrada"));
        viseira.setMarca(marcaRepository.findByIdOptional(dto.idMarca())
                .orElseThrow(() -> new EntityNotFoundException("Marca não encontrada")));
        viseira.setCor(corViseiraRepository.findByIdOptional(dto.idCorViseira())
                .orElseThrow(() -> new EntityNotFoundException("Cor da viseira não encontrada")));
        viseira.setTipo(dto.tipo());
        return new ViseiraResponseDTO(viseira);
    }

    @Transactional
    public void excluir(Long id) {
        Viseira viseira = viseiraRepository.findByIdOptional(id)
                .orElseThrow(() -> new EntityNotFoundException("Viseira não encontrada"));
        viseiraRepository.delete(viseira);
    }
}
