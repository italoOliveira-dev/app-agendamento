package com.italooliveira.app_agendamento.backend.controllers.impl;

import com.italooliveira.app_agendamento.backend.controllers.UsuarioController;
import com.italooliveira.app_agendamento.backend.dtos.requests.UsuarioCreateDTO;
import com.italooliveira.app_agendamento.backend.dtos.responses.UsuarioResponseDTO;
import com.italooliveira.app_agendamento.backend.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UsuarioControllerImpl implements UsuarioController {

    private final UsuarioService usuarioService;

    @Override
    public ResponseEntity<Void> cadastrarUsuario(UsuarioCreateDTO usuario) {
        usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<UsuarioResponseDTO> obterUsuariosPorId(Long id) {
        UsuarioResponseDTO usuario = usuarioService.obterUsuario(id);
        return ResponseEntity.ok(usuario);
    }
}
