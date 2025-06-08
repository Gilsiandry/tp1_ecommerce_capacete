package br.unitins.tp1.service.endereco;

import java.util.List;

import br.unitins.tp1.dto.endereco.EstadoDTO;
import br.unitins.tp1.model.endereco.Estado;

public interface EstadoService {

    Estado findById(Long id);

    List<Estado> findByNome(String nome);

    List<Estado> findAll();

    Estado create(EstadoDTO dto);

    Estado update(Long id, EstadoDTO dto);

    void delete(Long id);
    
}
