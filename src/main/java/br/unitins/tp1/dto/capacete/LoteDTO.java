package br.unitins.tp1.dto.capacete;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public record LoteDTO(
    @NotBlank(message = "O codigo deve ser informado.")
    @Size(min = 2, max = 40, message = "O codigo deve possuir entre 2 a 40 caracteres.")
    String codigo,

    @NotNull(message = "A data de fabricação deve ser informada.")
    @PastOrPresent(message = "A data de fabricação não pode estar no futuro.")
    LocalDate dataFabricacao) {

    }
    