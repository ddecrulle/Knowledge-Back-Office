package fr.insee.knowledge;

import fr.insee.knowledge.configuration.PropertiesLogger;
import fr.insee.knowledge.service.InitializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication(scanBasePackages = "fr.insee.knowledge", exclude = MongoAutoConfiguration.class)
public class StarterApplication {

    @Autowired
    private InitializerService initializer;

    public static void main(String[] args) {
        configureApplicationBuilder(new SpringApplicationBuilder()).build().run(args);
    }

    public static SpringApplicationBuilder configureApplicationBuilder(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder.sources(StarterApplication.class)
                .listeners(new PropertiesLogger());
    }


    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        initializer.createCollections();
    }
}