package br.unitins.tp1.service.pedido;

import java.util.List;

import br.unitins.tp1.dto.pedido.PedidoRequestDTO;
import br.unitins.tp1.model.pedido.Pedido;
import br.unitins.tp1.model.pedido.SituacaoPedido;

public interface PedidoService {

    Pedido findById(Long id);

    List<Pedido> findByUsername(String username);

    Pedido create(PedidoRequestDTO dto, String username);

    Pedido detailsPedido(Long id, String username);

    List<Pedido> eligbleReviews(Long idCliente, Long idCapacete);

   

    void updateStatusPedido(Long id, SituacaoPedido situacaoPedido);

    void verifyIfPaymentIsNull();

    void cancelPedido(String username, Long id);

    void returnPedido(String username, Long id);
    

}