package fr.insee.knowledge.openapi;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(OpenApiConfiguration.class);

    @Value("${fr.insee.knowledge.git.repository}")
    private String githubRepository;

    @Autowired
    BuildProperties buildProperties;

    @Bean
    public OpenAPI customOpenAPI() {
        return createOpenAPI();
    }

    private OpenAPI createOpenAPI() {
        logger.info("Overload of the classic swagger configuration");
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title(buildProperties.getName())
                        .description("Back-office services for Knowledge")
                        .version(buildProperties.getVersion())
                        .license(new License().name("LICENCE MIT").url(String.format("%s/blob/main/LICENSE", githubRepository))));
    }

}
