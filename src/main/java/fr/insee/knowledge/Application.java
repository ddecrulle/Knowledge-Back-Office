package fr.insee.knowledge;

import org.springdoc.core.SpringDocUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;


@SpringBootApplication(scanBasePackages = "fr.insee.knowledge", exclude = MongoAutoConfiguration.class)

public class Application {

    static {
        SpringDocUtils.getConfig().addHiddenRestControllers(BasicErrorController.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}