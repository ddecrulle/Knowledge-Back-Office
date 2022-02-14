package fr.insee.knowledge.configuration;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Autowired
    BuildProperties buildProperties;

    @Bean
    public Docket productApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        ArrayList<ResponseMessage> messages = Lists.newArrayList(
                new ResponseMessageBuilder().code(500).message("Erreur interne du côté serveur").build(),
                new ResponseMessageBuilder().code(403).message("Interdit!").build());
        docket.select().apis(RequestHandlerSelectors.basePackage("fr.insee.knowledge.controller")).build()
                .apiInfo(apiInfo()).useDefaultResponseMessages(false).globalResponseMessage(RequestMethod.GET, messages)
                .securitySchemes(List.of()).securityContexts(List.of());
        return docket;

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(buildProperties.getName(), "Back-office services for Knowledge", buildProperties.getVersion(),
                "", new Contact("Metallica", "https://github.com/ddecrulle/Knowledge-Back-Office", ""), "LICENSEE",
                "https://github.com/InseeFr/Queen-Back-Office/blob/master/LICENSE", List.of());
    }
}
