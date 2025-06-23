package com.italooliveira.app_agendamento.backend.services;

import com.italooliveira.app_agendamento.backend.dtos.requests.UsuarioCreateDTO;
import com.italooliveira.app_agendamento.backend.dtos.responses.UsuarioResponseDTO;

public interface UsuarioService {

    void  cadastrarUsuario(UsuarioCreateDTO usuario);

    UsuarioResponseDTO obterUsuario(Long id);
}
