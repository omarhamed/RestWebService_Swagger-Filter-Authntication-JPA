package com.restwebservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    public static Contact SUPPORTED_CONTACTS = new Contact("Omar Hamed Matar","https://github.com/omarhamed","oh83521@gmail.com");

    @Bean
    public Docket newApi(){
        Set produces = new HashSet<>(Arrays.asList("application/json","application/xml"));
        Set consumes = new HashSet<>(Arrays.asList("application/json","application/xml"));
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .produces(produces)
                .consumes(consumes);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee Service")
                .description("Employee Service With Swagger Doumentation")
                .termsOfServiceUrl("https://github.com/omarhamed")
                .contact(SUPPORTED_CONTACTS)
                .license("Employee licence Version 1.0")
                .licenseUrl("https://github.com/omarhamed/licence")
                .version("1.0").build();
    }

}
