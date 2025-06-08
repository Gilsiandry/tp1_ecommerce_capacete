package br.unitins.tp1.service.pedido;

import java.util.List;

import br.unitins.tp1.dto.pedido.EstoqueDTO;
import br.unitins.tp1.model.pedido.Estoque;

public interface EstoqueService {
    
    Estoque findById(Long id);

    Estoque findByCodigo(String codigo);

    Estoque findByIdCapacete(Long idCapacete);

    List<Estoque> findByIdCapaceteQtdeTotal(Long idCapacete);
    
    List<Estoque> findAll();

    Estoque create(EstoqueDTO dto);

    Estoque update(Long id, EstoqueDTO dto);

    void delete(Long id); 
}
