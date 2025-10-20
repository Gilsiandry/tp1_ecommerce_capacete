package br.unitins.tp1.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MunicipioRequestDTO(
@NotBlank(message = "O campo nome deve ser informado.")
String nome,

@NotNull(message = "O campo idEstado deve ser informado.")
Long idEstado) {
    
}
