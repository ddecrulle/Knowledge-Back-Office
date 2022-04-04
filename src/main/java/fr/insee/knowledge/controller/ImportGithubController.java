package fr.insee.knowledge.controller;

import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.service.ImportService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/import")
public class ImportGithubController {

    @Value("${fr.insee.knowledge.git.access.rawrepository}")
    private String githubRepository;

    @Autowired
    private ImportService importService;

    private final static Logger LOGGER = LoggerFactory.getLogger(ImportGithubController.class);

    @Operation(summary = "Import Functions")
    @GetMapping(path = "/functions")
    public ResponseEntity<String> importFunctions() throws IOException {
        String result = importService.importListFunctions(Constants.GithubFunctionFile);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @Operation(summary = "Import GSBPM")
    @GetMapping(path = "/hierarchy/gsbpm")
    public ResponseEntity<String> importGsbpm() throws IOException {
        String result = importService.importHierarchy(Constants.GithubGsbpmFile);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @Operation(summary = "Import Status")
    @GetMapping(path = "/hierarchy/status")
    public ResponseEntity<String> importStatus() throws IOException {
        String result = importService.importHierarchy(Constants.GithubStatusFile);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @Operation(summary = "Import Services")
    @GetMapping(path = "/hierarchy/services")
    public ResponseEntity<String> importServices() throws IOException {
        String result = importService.importHierarchy(Constants.GithubServicesFile);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @Operation(summary = "Import Products")
    @GetMapping(path = "/hierarchy/products")
    public ResponseEntity<String> importProducts() throws IOException {
        String result = importService.importHierarchy(Constants.GithubProductsFile);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @Operation(summary = "Import Users")
    @GetMapping(path = "/hierarchy/user")
    public ResponseEntity<String> importUsers() throws IOException {
        String result = importService.importHierarchy(Constants.GithubUserFile);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @Operation(summary = "Import All")
    @GetMapping(path = "/import.All")
    public ResponseEntity<String> importAll() throws IOException {
        List<String> results = importService.importAll();
        return new ResponseEntity<String>(results.toString(), HttpStatus.OK);
    }
}
