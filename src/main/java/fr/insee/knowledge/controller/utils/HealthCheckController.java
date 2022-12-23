package fr.insee.knowledge.controller.utils;

import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class HealthCheckController {
    private final static Logger logger = LoggerFactory.getLogger(HealthCheckController.class);

    @Operation(summary = "Healthcheck, check if api is alive")
    @GetMapping(path = "/healthcheck")
    public ResponseEntity<Object> healthCheck() {
        logger.info("HealthCheck");
        return ResponseEntity.ok().build();

    }
}
