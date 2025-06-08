package br.unitins.tp1.dto.capacete;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


public record InformacaoDTO(
    @NotBlank(message = "O descrição deve ser informado.")
    @Size(min = 2, max = 400, message = "A descrição deve possuir entre 2 a 400 caracteres.")
    String descricao,

    @NotNull(message = "O ano de lançamento deve ser informado.")
    @Positive(message = "O ano de lançamento deve deve ter 4 caracteres.")
    Integer anoLancamento) {

    }