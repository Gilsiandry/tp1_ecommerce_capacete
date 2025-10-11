package br.unitins.tp1.dto.pagamento;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PagamentoRequestDTO(
    @Positive(message = "Valor deve ser positivo.")
    Double valor,

    @NotNull(message = "Data de pagamento obrigatória.")
    LocalDateTime dataPagamento,

    @NotNull(message = "Tipo de pagamento obrigatório.")
    Integer idTipoPagamento){
    
}
