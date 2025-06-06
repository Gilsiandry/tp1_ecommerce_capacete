package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.pagamento.CartaoDTO;
import br.unitins.tp1.model.pagamento.Cartao;

public interface CartaoService {

    Cartao findById(String email, Long id);

    List<Cartao> findByCliente(String username);

    // List<Cartao> findAll();

    Cartao create(String email, CartaoDTO dto);

    void update(String email, Long idCartao, CartaoDTO dto);

    void delete(String email, Long id);
}