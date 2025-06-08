package br.unitins.tp1.dto.capacete;

import br.unitins.tp1.model.Informacao;


public record InformacaoResponseDTO(
    Long id,
    String descricao,
    Integer anoLancamento) {

    public static InformacaoResponseDTO valueOf(Informacao informacao) {
        if (informacao == null)
            return null;
        return new InformacaoResponseDTO(informacao.getId(), informacao.getDescricao(), informacao.getAnoLancamento());
    }
}