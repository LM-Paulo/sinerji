package com.teste.sinerji.adapters.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI CustomOpemAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("sinerji")
                        .version("V1")
                        .description("Crud")
                        .license(new License().name("Apache 2.0")));
    }
}
