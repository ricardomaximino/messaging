package com.verisure.vcp.newmicroservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Swagger configuration.  API documentation is available at /swagger-ui.html
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    // TODO (FaaS) Change in order to adapt to the actual microservice REST API.
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Application REST API",
                "Application manager REST API documentation.",
                "0.0.1-SNAPSHOT",
                "Terms of service based into company terms of use",
                new Contact("FaaS Securitas Direct", "https://faas.securitasdirect.local/", "faas@securitasdirect.es"),
                "License of API for YourCompany use only", 
                "License of API for YourCompany use only", 
                Collections.emptyList());
        return apiInfo;
    }
}
