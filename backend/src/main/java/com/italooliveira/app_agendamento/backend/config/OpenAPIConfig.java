package com.italooliveira.app_agendamento.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.open-api.titulo}") final String titulo,
                                 @Value("${springdoc.open-api.descricao}") final String descricao,
                                 @Value("${springdoc.open-api.versao}") final String versao) {

        return new OpenAPI()
                .info(
                        new Info()
                                .title(titulo)
                                .description(descricao)
                                .version(versao)
                );
    }
}
