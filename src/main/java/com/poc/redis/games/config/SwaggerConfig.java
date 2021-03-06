package com.poc.redis.games.config;

import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.poc.redis.games.api"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(informacoesApi().build());
    }

    private ApiInfoBuilder informacoesApi() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Games-API");
        apiInfoBuilder.description("Api para estudos.");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Deve ser usada para estudos.");
        apiInfoBuilder.license("Licença - Open Source");
        apiInfoBuilder.contact(contato());

        return apiInfoBuilder;

    }

    private Contact contato() {

        return new Contact(
                "Leonardo Dutra",
                null,
                "leo_dutra18@hotmail.com");
    }

}
