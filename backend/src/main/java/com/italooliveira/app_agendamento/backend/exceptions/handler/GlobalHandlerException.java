package com.italooliveira.app_agendamento.backend.exceptions.handler;

import com.italooliveira.app_agendamento.backend.exceptions.CpfJaCadastradoException;
import com.italooliveira.app_agendamento.backend.exceptions.EmailJaCadastradoException;
import com.italooliveira.app_agendamento.backend.exceptions.MensagemPadraoErro;
import com.italooliveira.app_agendamento.backend.exceptions.ValidacaoMensagemErro;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.italooliveira.app_agendamento.backend.utils.DateTimeUtils.formatarParaPadraoBrasileiro;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidacaoMensagemErro>  handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
                                                                                        HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidacaoMensagemErro erro = ValidacaoMensagemErro.builder()
                .path(request.getRequestURI())
                .status(status.value())
                .error(status.getReasonPhrase())
                .message("Campo(s) inválido(s).")
                .timestamp(formatarParaPadraoBrasileiro(LocalDateTime.now()))
                .erros(new ArrayList<>())
                .build();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()){
            erro.addErros(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<MensagemPadraoErro> handlerEmailJaCadastradoException(EmailJaCadastradoException ex, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        return ResponseEntity.status(status).body(
                MensagemPadraoErro.builder()
                        .path(request.getRequestURI())
                        .status(status.value())
                        .error(status.getReasonPhrase())
                        .message(ex.getMessage())
                        .timestamp(formatarParaPadraoBrasileiro(LocalDateTime.now()))
                        .build()
        );
    }

    @ExceptionHandler(CpfJaCadastradoException.class)
    public ResponseEntity<MensagemPadraoErro> handlerCpfJaCadastradoException(CpfJaCadastradoException ex, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        return ResponseEntity.status(status).body(
                MensagemPadraoErro.builder()
                        .path(request.getRequestURI())
                        .status(status.value())
                        .error(status.getReasonPhrase())
                        .message(ex.getMessage())
                        .timestamp(formatarParaPadraoBrasileiro(LocalDateTime.now()))
                        .build()
        );
    }
}
