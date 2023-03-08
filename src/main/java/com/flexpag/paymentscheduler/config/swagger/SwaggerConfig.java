package com.flexpag.paymentscheduler.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Component
public class SwaggerConfig {

    @Bean
    public OpenAPI retornarInfo(){
        return new OpenAPI()
        .info(detalhesApi());
    }

    private Info detalhesApi(){
        return new Info()
        .title("Serviço de pagamento agendado")
        .description("Aplicação Spring Boot para serviço de agendamento")
        .version("1.1.0");
    }
}
