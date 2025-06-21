package com.italooliveira.app_agendamento.backend.models.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum TipoUsuario {

    CLIENTE("CLIENTE"),
    PROFISSIONAL("PROFISSIONAL"),
    ADMIN("ADMIN");

    private final String tipoUsuario;

    public static TipoUsuario getTipoUsuario(final String tipoUsuario) {
        return Arrays.stream(TipoUsuario.values())
                .filter(descricao -> descricao.getTipoUsuario().equals(tipoUsuario))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo de usuário inválido " +  tipoUsuario));
    }

}
