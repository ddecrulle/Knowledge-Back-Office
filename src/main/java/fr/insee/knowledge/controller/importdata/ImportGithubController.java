package fr.insee.knowledge.controller.importdata;

import fr.insee.knowledge.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Tag(name = "Import Data", description = "Import Data from Github")
@RestController
@Slf4j
@RequestMapping(path = "/import")
public class ImportGithubController {
    private ImportService importService;
    private HierarchyProductSvc hierarchyProductSvc;
    private HierarchyGsbpmSvc hierarchyGsbpmSvc;
    private HierarchyUserSvc hierarchyUserSvc;
    private HierarchyServiceSvc hierarchyServiceSvc;

    public ImportGithubController(ImportService importService, HierarchyProductSvc hierarchyProductSvc, HierarchyGsbpmSvc hierarchyGsbpmSvc, HierarchyUserSvc hierarchyUserSvc, HierarchyServiceSvc hierarchyServiceSvc, FunctionService functionService) {
        this.importService = importService;
        this.hierarchyProductSvc = hierarchyProductSvc;
        this.hierarchyGsbpmSvc = hierarchyGsbpmSvc;
        this.hierarchyUserSvc = hierarchyUserSvc;
        this.hierarchyServiceSvc = hierarchyServiceSvc;
        this.functionService = functionService;
    }

    private FunctionService functionService;

    @Operation(summary = "Import Functions")
    @GetMapping(path = "/functions")
    public ResponseEntity<String> importFunctions() throws IOException {
        String result = functionService.importListFunctions();
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @Operation(summary = "Import GSBPM")
    @GetMapping(path = "/hierarchy/gsbpm")
    public ResponseEntity<String> importGsbpm() throws IOException {
        String result = hierarchyGsbpmSvc.importGsbpm();
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @Operation(summary = "Import Services")
    @GetMapping(path = "/hierarchy/services")
    public ResponseEntity<String> importServices() throws IOException {
        String result = hierarchyServiceSvc.importService();
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @Operation(summary = "Import Products")
    @GetMapping(path = "/hierarchy/products")
    public ResponseEntity<String> importProducts() throws IOException {
        String result = hierarchyProductSvc.importProduct();
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @Operation(summary = "Import Users")
    @GetMapping(path = "/hierarchy/user")
    public ResponseEntity<String> importUsers() throws IOException {
        String result = hierarchyUserSvc.importUser();
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @Operation(summary = "Import All")
    @GetMapping(path = "/import-hierarchy-and-functions")
    public ResponseEntity<String> importHierarchyAndFunction() throws IOException {
        String results = importService.importHierarchyAndFunction();
        return new ResponseEntity<String>(results, HttpStatus.OK);
    }
}
