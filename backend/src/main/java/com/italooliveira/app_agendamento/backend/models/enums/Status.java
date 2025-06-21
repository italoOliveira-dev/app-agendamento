package com.italooliveira.app_agendamento.backend.models.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum Status {

    PENDENTE("Pendente"),
    CONFIRMADO("Confirmado"),
    CANCELADO("Cancelado"),
    REALIZADO("Realizado"),
    NAO_COMPARECEU("Nao Compareceu"),
    EM_ANDAMENTO("Em Andamento");

    private final String status;

    public static Status getByStatus(final String aStatus) {
        return Arrays.stream(Status.values())
                .filter(status -> status.getStatus().equals(aStatus))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Status nao encontrado"));
    }
}
