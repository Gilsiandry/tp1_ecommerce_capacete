package br.unitins.tp1.dto.telefone;

public record TelefoneRequestDTO(
    String codigoArea,
    String numero) {

}



// import br.unitins.tp1.model.usuario.Telefone;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;

// public record TelefoneRequestDTO(
//                 @NotBlank(message = "O campo codigo de área deve ser informado") @Size(min = 2, max = 3, message = "O código de área conter 2 ou 3 digitos") String codigoArea,
//                 @NotBlank(message = "O campo codigo de área deve ser informado") @Size(min = 8, max = 9, message = "O campo número deve conter 8 ou 9 digitos ") String numero

// ) {
//         public static Telefone convert(TelefoneRequestDTO dto) {
//                 Telefone t = new Telefone();
//                 t.setCodigoArea(dto.codigoArea);
//                 t.setNumero(dto.numero);
//                 return t;
//         }
// }