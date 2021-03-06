package com.depromeet.dayblock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean

    public Docket api() {
        List global = new ArrayList();
        global.add(new ParameterBuilder().name("Authorization")
                .description("Access Token")
                .parameterType("header")
                .required(false)
                .defaultValue("Bearer ")
                .modelRef(new ModelRef("string"))
                .build());

        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(global)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.depromeet.dayblock"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("Dayblock API")
                .description("Dayblock API 입니다")
                .build();
    }
}
