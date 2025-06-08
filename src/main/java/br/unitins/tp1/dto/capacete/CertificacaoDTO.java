package br.unitins.tp1.dto.capacete;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CertificacaoDTO(
    @NotBlank(message = "O nome deve ser informado.")
    @Size(min = 4, max = 40, message = "O nome deve possuir entre 4 a 40 caracteres.")
    String nome,

    @NotBlank(message = "O pais deve ser informado.")
    @Size(min = 3, max = 40, message = "O pais deve possuir entre 3 a 40 caracteres.")
    String pais,

    @NotBlank(message = "A descricao deve ser informada.")
    @Size(min = 2, max = 400, message = "A descricao deve possuir entre 2 e 100 caracteres.")
    String descricao) {

    }