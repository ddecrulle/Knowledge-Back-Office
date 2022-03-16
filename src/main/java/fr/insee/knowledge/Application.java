package fr.insee.knowledge;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.SpringDocUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "fr.insee.knowledge")

public class Application {

	@Autowired
	BuildProperties buildProperties;

	static {
		SpringDocUtils.getConfig().addHiddenRestControllers(BasicErrorController.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}