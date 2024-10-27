package br.edu.multivix.pei.tolyid.infra.springdoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                        .title("Toly Id API")
                        .description("API Rest do projeto Toly Id, contendo as funcionalidades necessárias para a sincronização de capturas e manipulação dos dados gerados!")
                        .contact(new Contact()
                                .name("Guilherme Pagio - Desenvolvedor da API")
                                .email("guilhermepagio.contato@gmail.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://github.com/gPagio/multivix-pei-iv-toly-id-api/blob/main/LICENSE")));
    }
}