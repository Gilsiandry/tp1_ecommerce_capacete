package br.unitins.tp1.service.capacete;

import java.util.List;

import br.unitins.tp1.dto.capacete.MarcaRequestDTO;
import br.unitins.tp1.model.capacete.Marca;

public interface MarcaService {

    Marca findById(Long id);

    List<Marca> findByNome(String nome);

    List<Marca> findAll();

    Marca create(MarcaRequestDTO dto);

    void update(Long id, MarcaRequestDTO dto);

    void delete(Long id);

}