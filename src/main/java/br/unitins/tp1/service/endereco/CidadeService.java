package br.unitins.tp1.service.endereco;

import java.util.List;

import br.unitins.tp1.dto.endereco.CidadeDTO;
import br.unitins.tp1.model.endereco.Cidade;

public interface CidadeService {

    Cidade findById(Long id);

    List<Cidade> findByNome(String nome);

    List<Cidade> findAll();

    Cidade create(CidadeDTO dto);

    Cidade update(Long id, CidadeDTO dto);

    void delete(Long id);
    
}
