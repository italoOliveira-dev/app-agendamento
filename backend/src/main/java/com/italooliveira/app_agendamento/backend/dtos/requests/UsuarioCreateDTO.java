package com.italooliveira.app_agendamento.backend.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public record UsuarioCreateDTO(@NotBlank(message = "Campo nome é obrigatório!")
                               @Size(min = 3, max = 100, message = "Nome de ter tamanho entre 3 e 100 character!")
                               @Schema(example = "Meu nome")
                               String nome,

                               @NotBlank(message = "Campo email é obrigatório!")
                               @Email(
                                       regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{3}$",
                                       message = "Email inválido!"
                               )
                               @Size(max = 100, message = "Valor máximo é de 100 character!")
                               @Schema(example = "email@email.com")
                               String email,

                               @Size(min = 8, message = "Senha deve conter no mínimo 8 character!")
                               @Pattern(
                                       regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
                                       message = "A senha deve conter pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial."
                               )
                               @Schema(
                                       description = "Senha do usuário (mínimo 8 caracteres, com maiúscula, minúscula, número e caractere especial)",
                                       example = "MinhaSenha123!"
                               )
                               String senha,

                               @NotBlank(message = "Campo cpf é obrigatório!")
                               @CPF
                               @Schema(example = "12345678900")
                               String cpf,

                               @NotBlank(message = "Campo telefone é obrigatório!")
                               @Schema(example = "11987654321")
                               String telefone,

                               @Schema(example = "https://example.com/foto.jpg")
                               String foto,

                               @Schema(example = "CLIENTE", allowableValues = {"ADMIN", "CLIENTE", "PROFISSIONAL"})
                               String tipoUsuario
) {

    public UsuarioCreateDTO {
        nome = (nome != null) ? nome.trim() : null;
    }
}
