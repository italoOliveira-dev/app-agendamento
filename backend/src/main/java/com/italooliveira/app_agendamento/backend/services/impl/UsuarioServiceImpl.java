package com.italooliveira.app_agendamento.backend.services.impl;

import com.italooliveira.app_agendamento.backend.dtos.requests.UsuarioCreateDTO;
import com.italooliveira.app_agendamento.backend.mapper.UsuarioMapper;
import com.italooliveira.app_agendamento.backend.repositories.UsuarioRepository;
import com.italooliveira.app_agendamento.backend.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public void cadastrarUsuario(UsuarioCreateDTO usuarioDTO) {
        usuarioRepository.save(usuarioMapper.toEntity(usuarioDTO));
    }
}
