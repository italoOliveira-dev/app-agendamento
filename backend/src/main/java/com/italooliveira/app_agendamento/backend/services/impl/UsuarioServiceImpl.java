package com.italooliveira.app_agendamento.backend.services.impl;

import com.italooliveira.app_agendamento.backend.dtos.requests.UsuarioCreateDTO;
import com.italooliveira.app_agendamento.backend.exceptions.CpfJaCadastradoException;
import com.italooliveira.app_agendamento.backend.exceptions.EmailJaCadastradoException;
import com.italooliveira.app_agendamento.backend.mapper.UsuarioMapper;
import com.italooliveira.app_agendamento.backend.models.Usuario;
import com.italooliveira.app_agendamento.backend.repositories.UsuarioRepository;
import com.italooliveira.app_agendamento.backend.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    @Transactional
    public void cadastrarUsuario(UsuarioCreateDTO usuarioDTO) {
        Optional<Usuario> emailJaExiste = usuarioRepository.findByEmail(usuarioDTO.email());
        Optional<Usuario> cpfJaExiste = usuarioRepository.findByCpf(usuarioDTO.cpf());
        if (emailJaExiste.isPresent()) {
            throw new EmailJaCadastradoException(String.format("Email '%s' já cadastrado!", usuarioDTO.email()));
        }
        if (cpfJaExiste.isPresent()) {
            throw new CpfJaCadastradoException(String.format("Cpf '%s' já cadastrado!", usuarioDTO.cpf()));
        }

        usuarioRepository.save(usuarioMapper.toEntity(usuarioDTO));
    }
}
