package br.unitins.tp1.dto.usuario;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PessoaJuridicaDTO (
    @NotBlank(message = "O nome deve ser informado.")
    @Size(max = 60, message = "O nome deve possuir no máximo 60 caracteres.")
    String nome,

    @Size(min = 14, max = 14, message = "O cnpj deve possuir 14 caracteres.")
    @NotNull(message = "O cnpj não pode ser nulo.")
    String cnpj
) implements PessoaDTO {
    @JsonCreator
    public PessoaJuridicaDTO {
    }
}