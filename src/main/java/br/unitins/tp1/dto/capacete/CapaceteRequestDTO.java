package br.unitins.tp1.dto.capacete;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CapaceteRequestDTO(
        @NotBlank(message = "O campo nome deve ser informado")
        String nome,
        
        @NotNull(message = "O campo preço deve ser informado")
        Double preco,

        @NotNull(message = "O campo categoria deve ser informado")
        Long idCategoria,

        @NotNull(message = "O campo modelo deve ser informado")
        Long idModelo,

        @NotNull(message = "O campo jugular deve ser informado")
        int idJugular,

        @NotNull(message = "O campo viseira deve ser informado")
        Long idViseira,

        @NotBlank(message = "O campo cor deve ser informado")
        String idCor,

        @NotNull(message = "O campo tamanho deve ser informado")
        int idTamanho) {

}