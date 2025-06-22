package com.italooliveira.app_agendamento.backend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
public class ValidacaoMensagemErro extends MensagemPadraoErro{

    @Getter
    List<CamposErros> erros;

    @AllArgsConstructor
    @Getter
    private static class CamposErros {
        private String campo;
        private String mensagem;
    }

    public void addErros(final String campo, final String mensagem) {
        this.erros.add(new CamposErros(campo, mensagem));
    }
}
