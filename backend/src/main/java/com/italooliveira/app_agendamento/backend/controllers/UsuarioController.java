package com.italooliveira.app_agendamento.backend.controllers;

import com.italooliveira.app_agendamento.backend.dtos.requests.UsuarioCreateDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/usuarios")
public interface UsuarioController {

    @PostMapping("/cadastro")
    ResponseEntity<Void> cadastrarUsuario(@Valid @RequestBody UsuarioCreateDTO usuario);
}
