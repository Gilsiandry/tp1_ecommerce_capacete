package br.unitins.tp1.dto.capacete;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CapaceteRequestDTO(
                @NotBlank(message = "O campo código de barras deve ser informado") String codigo,
                @NotBlank(message = "O campo nome deve ser informado") String nome,
                @NotBlank(message = "O campo cor deve ser informado") String cor,
                @NotNull(message = "O campo tamanho deve ser informado") int tamanho,
                @NotNull(message = "O campo preço deve ser informado") Double preco,
                @NotNull(message = "O campo marca deve ser informado") Long idMarca,
                @NotNull(message = "O campo tipo capacete deve ser informado") int idTipoCapacete) {

}