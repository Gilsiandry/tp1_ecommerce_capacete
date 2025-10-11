package br.unitins.tp1.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoRequestDTO(
    @NotBlank(message = "Logradouro obrigatório.")
    String logradouro,

    @NotBlank(message = "Bairro obrigatório.")
    String bairro,

    @NotBlank(message = "Número obrigatório.")
    String numero,

    String complemento,

    @NotBlank(message = "CEP obrigatório.")
    String cep,

    @NotNull(message = "Cidade obrigatória.")
    Long idCidade){
    
}
