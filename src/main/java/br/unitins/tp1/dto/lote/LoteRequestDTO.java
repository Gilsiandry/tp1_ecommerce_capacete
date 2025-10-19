// package br.unitins.tp1.dto.lote;

// import java.time.LocalDate;

// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.PastOrPresent;
// import jakarta.validation.constraints.Positive;

// public record LoteRequestDTO(
//         @NotBlank(message = "O campo código deve ser informado")
//         String codigo,

//         @Positive(message = "O campo quantidade deve ser positivo")
//         Integer quantidade,

//         @NotNull(message = "A data não pode ser nula") @PastOrPresent(message = "A data informada deve ser de hoje ou estar no passado")
//         LocalDate dataFabricacao, 

//         @NotNull(message = "O campo id capacete deve ser informado.")
//         Long idCapacete) {

// }