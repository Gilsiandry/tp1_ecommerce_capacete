package br.unitins.tp1.service.pagamento;

import br.unitins.tp1.model.pagamento.Boleto;
import br.unitins.tp1.model.pagamento.Pagamento;
import br.unitins.tp1.model.pagamento.Pix;
import br.unitins.tp1.model.pagamento.TipoPagamento;

public interface PagamentoService {

    Pagamento findById(Long id);

    Pix gerarPix(Long idPedido, String username);

    Boleto gerarBoleto(Long idPedido, String username);

    void pagar(Long idPedido, String username, String identificador, TipoPagamento tipoPagamento);

    void pagarCartao(Long idPedido, String username, Long idCartao);

}