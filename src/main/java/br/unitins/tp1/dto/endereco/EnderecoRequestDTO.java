package br.unitins.tp1.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoRequestDTO(

                @NotNull(message = "O campo cidade deve ser informado") Long idCidade,
                @NotBlank(message = "O campo logradouro deve ser informado") String logradouro,
                @NotBlank(message = "O campo bairro deve ser informado") String bairro,
                @NotBlank(message = "O campo numero deve ser informado") String numero,
                @NotBlank(message = "O complemento deve ser informado") String complemento,
                @NotBlank(message = "O campo CEP deve ser informado") String cep) {

}