package com.integradis.greenhouse.platform.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class OpenApiConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200", "https://greenhouse-open.netlify.app", "*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
    @Bean
    public OpenAPI greenhousePlatformOpenApi() {
        final String securitySchemaName = "bearerAuth";
        var openApi = new OpenAPI();
        openApi
                .info(new Info()
                        .title("Greenhouse Platform API")
                        .description("Greenhouse Platform application REST API documentation")
                        .version("v1.1.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Greenhouse Platform wiki Documentation")
                        .url("https://greenhouse-platform.wiki.github.io/docs"));

        openApi
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemaName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemaName,
                                new SecurityScheme()
                                        .name(securitySchemaName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));

        return openApi;
    }
}
