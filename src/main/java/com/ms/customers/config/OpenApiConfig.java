package com.ms.customers.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de clientes y créditos",
                version = "1.0.0",
                description = "Api para la gestión de los clientes y créditos"
        )
)
public class OpenApiConfig {
}
