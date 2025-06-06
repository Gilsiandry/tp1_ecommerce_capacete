package br.unitins.tp1.dto.pagamento;

import java.time.LocalDateTime;

import br.unitins.tp1.model.pagamento.Boleto;

public record BoletoResponseDTO(
    Long id,
    String codigoBarras,
    LocalDateTime validade,
    Double valor
){

    public static BoletoResponseDTO valueOf(Boleto boleto) {
        return new BoletoResponseDTO(
            boleto.getId(),
            boleto.getCodigoBarras(),
            boleto.getValidade(),
            boleto.getValor());
    }

}