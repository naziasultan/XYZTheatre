package com.theatre.xyz.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Theatre Service API", version = "1.0", description = "Theatre Service"))
public class SwaggerConfiguration {


    @Bean
    public GroupedOpenApi api()
    {
        return GroupedOpenApi.builder()
                .group("default")
                .pathsToMatch("/api/**")
                .packagesToScan("com.theatre.xyz.controller")
                .build();
    }}