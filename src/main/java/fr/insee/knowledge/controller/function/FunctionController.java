package fr.insee.knowledge.controller.function;

import fr.insee.knowledge.domain.Function;
import fr.insee.knowledge.service.FunctionService;
import fr.insee.knowledge.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping(path = "/function")
public class FunctionController {

    private final static Logger logger = LoggerFactory.getLogger(FunctionController.class);

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

    @Value("${fr.insee.knowledge.git.access.rawrepository}")
    private String githubRepository;

    @Operation(summary = "Test function")
    @GetMapping(path = "/test")
    public ResponseEntity<Object> testFunctions() throws IOException {
        String strFunctions = Utils.readFileFromUrl(new URL(githubRepository + "functions/fonctions.json"));


        Object object = Document.parse("{\"json\":" + strFunctions + "}").get("json");

        return new ResponseEntity<Object>(object, HttpStatus.OK);
    }

    private List<Function> listFunctionsFromJson(String jsonContent) {
        return null;
    }


}
