package com.teamsparta.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun getSwaggerConfig(): OpenAPI {
        return OpenAPI().components(Components())
            .info(Info().title("ToDoList API").description("schema").version("1.0.0"))
    }
}