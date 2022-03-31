package fr.insee.knowledge;

import fr.insee.knowledge.service.InitializerService;
import org.springdoc.core.SpringDocUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;


@SpringBootApplication(scanBasePackages = "fr.insee.knowledge", exclude = MongoAutoConfiguration.class)
public class Application {

    static {
        SpringDocUtils.getConfig().addHiddenRestControllers(BasicErrorController.class);
    }

    @Autowired
    private InitializerService initializer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() throws IOException {
        initializer.createCollections();
        initializer.importDataFromGithub();

    }
}