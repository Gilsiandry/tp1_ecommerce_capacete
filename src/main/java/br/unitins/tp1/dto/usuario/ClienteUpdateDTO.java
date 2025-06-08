package br.unitins.tp1.dto.usuario;

import java.time.LocalDate;
import java.util.List;

import br.unitins.tp1.dto.TelefoneDTO;
import br.unitins.tp1.dto.endereco.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteUpdateDTO(
    @NotBlank(message = "O campo nome deve ser informado.")
    String nome,
    @NotBlank(message = "O campo cpf deve ser informado.")
    String cpf,
    @NotNull(message = "O campo data de nascimento deve ser informado")
    LocalDate dataNascimento,
    @Valid
    List<TelefoneDTO> telefones,
    @Valid
    List<EnderecoDTO> enderecos) {
    
}
