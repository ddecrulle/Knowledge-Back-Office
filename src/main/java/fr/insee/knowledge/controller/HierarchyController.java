package fr.insee.knowledge.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/Hierarchy")
public class HierarchyController {

    private final static Logger LOGGER = LoggerFactory.getLogger(HierarchyController.class);

    @Operation(summary = "Get Hierarchy")
    @GetMapping(path = "/hierarchy")
    public ResponseEntity<Object> getHierarchy() {
        return null;
    }
}
