package fr.insee.knowledge.controller.function;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.domain.Function;
import fr.insee.knowledge.domain.ServiceBpmn;
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
import java.util.ArrayList;
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

    public static List<Function> listFunctionsFromJson(String jsonContent) throws JsonProcessingException {
        List<Function> res = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonContent);
        //TODO handle case when rootNode is empty
        JsonNode firstServiceNode = rootNode.get(0);
        ServiceBpmn firstMacroService = new ServiceBpmn();
        recursiveMapping(res, firstServiceNode, firstMacroService);
        return res;
    }

    private static void recursiveMapping(List<Function> functionList, JsonNode jsonNode, ServiceBpmn currentService) {
        currentService.setId(jsonNode.get("id").asText());
        currentService.setLabel(jsonNode.get("label").asText());
        // ...
        JsonNode functionNodeArray = jsonNode.get("fonction");
        if (functionNodeArray != null) {
            for (JsonNode functionNode : functionNodeArray) {
                Function function = new Function();
                function.setLabel(functionNode.get("label").asText());
                // ...
                function.setServiceBpmn(currentService);
                functionList.add(function);
            }
        } else {
            if (jsonNode.get("service") == null) {
                System.out.println(jsonNode);
            }
            for (JsonNode serviceNode : jsonNode.get("service")) {
                ServiceBpmn service = new ServiceBpmn();
                service.setServiceBpmn(currentService);
                recursiveMapping(functionList, serviceNode, service);
            }
        }
    }
}
