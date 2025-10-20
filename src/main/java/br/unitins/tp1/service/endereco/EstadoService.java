package br.unitins.tp1.service.endereco;

import java.util.List;

import br.unitins.tp1.dto.endereco.EstadoRequestDTO;
import br.unitins.tp1.model.endereco.Estado;
import jakarta.validation.Valid;

public interface EstadoService {

    Estado create(@Valid EstadoRequestDTO estado);
    void update(long id, EstadoRequestDTO estado);
    void delete(long id);
    Estado findById(long id);
    Estado findBySigla(String sigla);
    List<Estado> findAll(Integer page, Integer pageSize);
    List<Estado> findByNome(String nome, Integer page, Integer pageSize);
    long count();
    long count(String nome);
    
}