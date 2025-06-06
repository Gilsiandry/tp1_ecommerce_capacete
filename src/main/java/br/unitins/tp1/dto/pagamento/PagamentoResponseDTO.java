package br.unitins.tp1.dto.pagamento;

import br.unitins.tp1.model.pagamento.Boleto;
import br.unitins.tp1.model.pagamento.DadosCartao;
import br.unitins.tp1.model.pagamento.Pagamento;
import br.unitins.tp1.model.pagamento.Pix;

public record PagamentoResponseDTO(Object Pagamento) {
    
    public static Object valueOf(Pagamento pagamento) {
        if (pagamento instanceof Boleto) {
            Boleto boleto = (Boleto) pagamento;
            return BoletoResponseDTO.valueOf(boleto);
        }

        if (pagamento instanceof Pix) {
            Pix pix = (Pix) pagamento;
            return PixResponseDTO.valueOf(pix);
        }

        if (pagamento instanceof DadosCartao) {
            DadosCartao cartao = (DadosCartao) pagamento;
            return CartaoResponseDTO.valueOf(cartao);
        }

        return null;
    }

}