// package br.unitins.tp1.dto.usuario;

// import java.time.LocalDate;

// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Size;

// public record UsuarioRequestDTO(
//         @NotBlank(message = "O campo nome de usuario deve ser informado")
//         String username,

//         @NotBlank(message = "O campo senha deve ser informado") @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres")
//         String senha,

//         @NotBlank(message = "O email deve ser informado") @Email(message = "O email deve ser válido")
//         String email,
        
//         @NotNull(message = "O campo data de cadastro deve ser informado.")
//         LocalDate dataCadastro,

//         @NotNull(message = "Perfil obrigatório.")
//         Integer idPerfil) {

// }