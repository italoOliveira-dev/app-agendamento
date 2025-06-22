package com.italooliveira.app_agendamento.backend.exceptions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class MensagemPadraoErro {

    private String path;
    private Integer status;
    private String error;
    private String message;
    private String timestamp;

}
