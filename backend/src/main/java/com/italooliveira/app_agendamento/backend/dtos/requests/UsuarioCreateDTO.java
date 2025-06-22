package com.italooliveira.app_agendamento.backend.dtos.requests;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public record UsuarioCreateDTO(@NotBlank(message = "Campo nome é obrigatório!")
                               @Size(min = 3, max = 100, message = "Nome de ter tamanho entre 3 e 100 character!")
                               String nome,

                               @NotBlank(message = "Campo email é obrigatório!")
                               @Email(
                                       regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{3}$",
                                       message = "Email inválido!"
                               )
                               @Size(max = 100, message = "Valor máximo é de 100 character!")
                               String email,

                               @Size(min = 8, message = "Senha deve conter no mínimo 8 character!")
                               @Pattern(
                                       regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
                                       message = "A senha deve conter pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial."
                               )
                               String senha,

                               @NotBlank(message = "Campo cpf é obrigatório!")
                               @CPF
                               String cpf,

                               @NotBlank(message = "Campo telefone é obrigatório!")
                               String telefone,
                               String foto,
                               String tipoUsuario
) {

    public UsuarioCreateDTO {
        nome = (nome != null) ? nome.trim() : null;
    }
}
