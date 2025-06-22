package com.italooliveira.app_agendamento.backend.controllers;

import com.italooliveira.app_agendamento.backend.dtos.requests.UsuarioCreateDTO;
import com.italooliveira.app_agendamento.backend.exceptions.MensagemPadraoErro;
import com.italooliveira.app_agendamento.backend.exceptions.ValidacaoMensagemErro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "UsuarioController", description = "Controller responsável pelas operações de usuários.")
@RequestMapping("/api/usuarios")
public interface UsuarioController {

    @Operation(summary = "Cadastrar novo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ValidacaoMensagemErro.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Conflict",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MensagemPadraoErro.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MensagemPadraoErro.class)
                    )
            )

    })
    @PostMapping("/cadastro")
    ResponseEntity<Void> cadastrarUsuario(@Valid @RequestBody UsuarioCreateDTO usuario);
}
