package br.unitins.tp1.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EnderecoDTO(
    @NotBlank(message = "O campo logradouro deve ser informado") 
    String logradouro,
    @NotBlank(message = "O campo bairro deve ser informado") 
    String bairro,
    @NotBlank(message = "O campo numero deve ser informado") 
    String numero,
    String complemento,
    @NotBlank(message = "O campo CEP deve ser informado") 
    String cep,
    @NotNull(message = "O campo id da cidade deve ser informado")
    @Positive(message = "O campo id da cidade deve ser informado corretamente.")
    Long idCidade) {
    
}
