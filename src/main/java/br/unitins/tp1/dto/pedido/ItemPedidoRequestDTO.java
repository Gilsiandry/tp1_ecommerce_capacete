package br.unitins.tp1.dto.pedido;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ItemPedidorequestDTO(
    @NotNull(message = "Capacete obrigatório.")
    Long idCapacete,

    @Positive(message = "Quantidade deve ser positiva.")
    Integer quantidade,

    @Positive(message = "Preço deve ser positivo.")
    Double preco){
    
}
