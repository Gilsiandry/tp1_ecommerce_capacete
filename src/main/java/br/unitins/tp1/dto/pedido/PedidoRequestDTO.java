package br.unitins.tp1.dto.pedido;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


public class PedidoRequestDTO(
    @NotNull(message = "Data obrigatória.")
    LocalDateTime data,

    @NotNull(message = "Usuário obrigatório.")
    Long idUsuario,

    @NotNull(message = "Endereço de entrega obrigatório.")
    Long idEnderecoEntrega,

    @NotNull(message = "Itens obrigatórios.")
    List<ItemPedidoDTO> itens){
    
}
