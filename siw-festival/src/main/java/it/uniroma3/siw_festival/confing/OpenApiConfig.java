package it.uniroma3.siw_festival.confing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("SIW Movie API")
                .version("v1")
                .description("API REST per la gestione di SIW FESTIVAL"));
    }
}