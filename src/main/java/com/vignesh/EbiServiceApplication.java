package com.vignesh;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class EbiServiceApplication
{
public static void main(String[] args) 
{
SpringApplication.run(EbiServiceApplication.class, args);
}
@Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.paths(PathSelectors.ant("/api/*"))
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.vignesh"))
                .build()
                .apiInfo(apiDetails());
    }
    private ApiInfo apiDetails(){
        return new ApiInfo(
                "EBI Service API",
                "Sample CRUD API for Person",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Vignesh Venkatesh","https://github.com/vigneshvicky1994","vigneshbabu.venkatesh@gmail.com"),
                "Api License",
                "",
                Collections.emptyList()
        );
    }
}
