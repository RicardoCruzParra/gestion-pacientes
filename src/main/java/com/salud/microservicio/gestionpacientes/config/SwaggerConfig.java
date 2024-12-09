package com.salud.microservicio.gestionpacientes.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Pacientes - Sector Salud")
                        .version("1.0")
                        .description("Documentación de la API para gestionar la información de pacientes.")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("soporte@sector-salud.com")));
    }
}
