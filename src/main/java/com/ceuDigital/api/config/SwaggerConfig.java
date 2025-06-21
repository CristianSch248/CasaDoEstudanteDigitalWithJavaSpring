package com.ceuDigital.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig
{
    @Bean
    public OpenAPI customOpenAPI()
    {
        return new OpenAPI()
                .info(new Info()
                        .title("Casa do Estudante Digital API")
                        .version("1.0.0")
                        .description("API REST para gestão de vistorias, manutenções e moradores da Casa do Estudante."));
    }
}
