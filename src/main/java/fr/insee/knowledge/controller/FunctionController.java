package fr.insee.knowledge.controller;

import fr.insee.knowledge.service.FunctionService;
import io.swagger.v3.oas.annotations.Operation;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/function")
public class FunctionController {

    private final static Logger LOGGER = LoggerFactory.getLogger(FunctionController.class);

    @Autowired
    private FunctionService functionService;

    @Operation(summary = "Get function by id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Document> getFunctionById(@PathVariable(value = "id") String id) {
        Document result = functionService.getFunctionById(id);
        return new ResponseEntity<Document>(result, HttpStatus.OK);
    }

    @Operation(summary = "Get all functions")
    @GetMapping(path = "/all")
    public ResponseEntity<List<Document>> getAllFunctions() {
        List<Document> result = functionService.getAllFunctions();
        return new ResponseEntity<List<Document>>(result, HttpStatus.OK);
    }
}
