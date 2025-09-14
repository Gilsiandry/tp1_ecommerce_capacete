package br.unitins.tp1.model.pedido;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.unitins.tp1.validation.EntidadeNotFoundException;

@JsonFormat(shape = Shape.OBJECT)
public enum SituacaoPedido {

    aguardandoPagamento(1, "O pedido está aguardando pagamento"),
    pagamentoConfirmado(2, "Pagamento confirmado com sucesso"),
    cancelado(3, "O pedido foi cancelado"),
    enviado(4, "O pedido foi enviado"),
    entregue(5, "O pedido foi entregue"),
    devolvido(6, "O pedido foi deolvido");

    private final Integer id;
    private final String label;

    private SituacaoPedido(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static SituacaoPedido valueOf(Integer id) {
        if (id.equals(null))
            return null;
        for (SituacaoPedido tipo : values()) {
            if (tipo.getId().equals(id))
                return tipo;
        }

        throw new EntidadeNotFoundException("idSituacaoPedido", "Tipo de situação não encontrado!");
    }

}
