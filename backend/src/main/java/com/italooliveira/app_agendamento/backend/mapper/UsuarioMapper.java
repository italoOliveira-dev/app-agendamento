package com.italooliveira.app_agendamento.backend.mapper;

import com.italooliveira.app_agendamento.backend.dtos.requests.UsuarioCreateDTO;
import com.italooliveira.app_agendamento.backend.models.Usuario;
import com.italooliveira.app_agendamento.backend.models.enums.TipoUsuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMapper {

    public Usuario toEntity(UsuarioCreateDTO usuarioDTO) {

        return Usuario.builder()
                .nome(usuarioDTO.nome())
                .email(usuarioDTO.email())
                .senha(usuarioDTO.senha())
                .cpf(usuarioDTO.cpf())
                .telefone(usuarioDTO.telefone())
                .foto(usuarioDTO.foto())
                .tipoUsuario(TipoUsuario.getTipoUsuario(usuarioDTO.tipoUsuario()))
                .build();
    }
}
