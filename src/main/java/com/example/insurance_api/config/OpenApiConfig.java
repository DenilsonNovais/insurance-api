package com.example.insurance_api.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Insurance API")
                        .version("v1")
                        .description("API de exemplo para desafio técnico - gerenciamento de apólices"))
                .externalDocs(new ExternalDocumentation().description("README").url("/"));
    }
}