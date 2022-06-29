package fr.insee.knowledge.controller.function;

import fr.insee.knowledge.domain.Function;
import fr.insee.knowledge.service.FunctionService;
import io.swagger.v3.oas.annotations.Operation;
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

    private final static Logger logger = LoggerFactory.getLogger(FunctionController.class);

    @Autowired
    private FunctionService functionService;

    @Operation(summary = "Get function by id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Function> getFunctionById(@PathVariable(value = "id") String id) {
        Function result = functionService.getFunctionById(id);
        return new ResponseEntity<Function>(result, HttpStatus.OK);
    }

    @Operation(summary = "Get all functions")
    @GetMapping(path = "/all")
    public ResponseEntity<List<Function>> getAllFunctions() {
        List<Function> result = functionService.getAllFunctions();
        return new ResponseEntity<List<Function>>(result, HttpStatus.OK);
    }

}
