package br.com.zup.initial.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerCustomConfiguration {

    @Value("${enviroments.project-version}")
    private String version;

    @Value("${enviroments.project-name}")
    private String title;

    @Value("${enviroments.any-name-enviroment: Optional Message For Empty Enviroment}")
    private String description;

    @Value("${enviroments.any-name-no-exist: Optional Message For Empty Enviroment}")
    private String license;


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .version(version)
                        .description(description)
                        .license(new License().name("Apache 2.0" + license).url("http://springdoc.org")));
    }

}
