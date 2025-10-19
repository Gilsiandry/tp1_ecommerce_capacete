// package br.unitins.tp1.dto.pessoa;

// import java.math.BigDecimal;
// import java.time.LocalDate;

// import org.hibernate.validator.constraints.br.CPF;

// import jakarta.validation.constraints.NotBlank;

// public record FuncionarioUpdateRequestDTO(
//         @NotBlank(message = "O campo nome deve ser informado.") String nome,
//         @NotBlank(message = "O campo CPF deve ser informado.") @CPF(message = "O CPF informado está em formato inválido") String cpf,
//         LocalDate dataNascimento,
//         LocalDate dataContratacao,
//         String cargo,
//         BigDecimal salario) {

// }
