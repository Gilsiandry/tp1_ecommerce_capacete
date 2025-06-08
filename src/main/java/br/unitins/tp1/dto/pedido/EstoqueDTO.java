package br.unitins.tp1.dto.pedido;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EstoqueDTO(
    @NotNull(message = "O campo idCapacete deve ser informado.")
    Long idCapacete,
    @NotNull(message = "O campo data deve ser informado.")
    LocalDate data,
    @NotBlank(message = "O campo codigo deve ser informado.")
    String codigo,
    @NotNull(message = "O campo codigo deve ser informado.")
    @Positive
    Integer estoque
) {
    
}
