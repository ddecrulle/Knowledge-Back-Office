package fr.insee.knowledge.controller.importdata;

import fr.insee.knowledge.service.*;
import fr.insee.knowledge.service.impl.HierarchyGsbpmServiceImpl;
import fr.insee.knowledge.service.impl.HierarchyProductServiceImpl;
import fr.insee.knowledge.service.impl.HierarchySvcServiceImpl;
import fr.insee.knowledge.service.impl.HierarchyUserServiceImpl;
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
    private HierarchyProductServiceImpl hierarchyProductSvc;
    private HierarchyGsbpmServiceImpl hierarchyGsbpmSvc;
    private HierarchyUserServiceImpl hierarchyUserSvc;
    private HierarchySvcServiceImpl hierarchyServiceSvc;

    public ImportGithubController(ImportService importService, HierarchyProductServiceImpl hierarchyProductSvc, HierarchyGsbpmServiceImpl hierarchyGsbpmSvc,
                                  HierarchyUserServiceImpl hierarchyUserSvc, HierarchySvcServiceImpl hierarchyServiceSvc, FunctionService functionService) {
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
        String result = hierarchyGsbpmSvc.importHierarchy();
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @Operation(summary = "Import Services")
    @GetMapping(path = "/hierarchy/services")
    public ResponseEntity<String> importServices() throws IOException {
        String result = hierarchyServiceSvc.importHierarchy();
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @Operation(summary = "Import Products")
    @GetMapping(path = "/hierarchy/products")
    public ResponseEntity<String> importProducts() throws IOException {
        String result = hierarchyProductSvc.importHierarchy();
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @Operation(summary = "Import Users")
    @GetMapping(path = "/hierarchy/user")
    public ResponseEntity<String> importUsers() throws IOException {
        String result = hierarchyUserSvc.importHierarchy();
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @Operation(summary = "Import All")
    @GetMapping(path = "/import-hierarchy-and-functions")
    public ResponseEntity<String> importHierarchyAndFunction() throws IOException {
        String results = importService.importHierarchyAndFunction();
        return new ResponseEntity<String>(results, HttpStatus.OK);
    }
}
