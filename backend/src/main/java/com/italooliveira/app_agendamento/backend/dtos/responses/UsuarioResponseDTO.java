package com.italooliveira.app_agendamento.backend.dtos.responses;

public record UsuarioResponseDTO(Long id,
                                 String nome,
                                 String email,
                                 String telefone,
                                 String cpf,
                                 String foto) {
}
