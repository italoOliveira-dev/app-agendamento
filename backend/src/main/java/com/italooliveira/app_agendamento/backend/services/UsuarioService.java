package com.italooliveira.app_agendamento.backend.services;

import com.italooliveira.app_agendamento.backend.dtos.requests.UsuarioCreateDTO;

public interface UsuarioService {

    void  cadastrarUsuario(UsuarioCreateDTO usuario);
}
