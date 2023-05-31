package fr.insee.knowledge.controller.importdata;

import fr.insee.knowledge.controller.errors.ErrorResponse;
import fr.insee.knowledge.service.FunctionService;
import fr.insee.knowledge.service.ImportService;
import fr.insee.knowledge.service.exceptions.FunctionValidationException;
import fr.insee.knowledge.service.impl.HierarchyGsbpmServiceImpl;
import fr.insee.knowledge.service.impl.HierarchyProductServiceImpl;
import fr.insee.knowledge.service.impl.HierarchySvcServiceImpl;
import fr.insee.knowledge.service.impl.HierarchyUserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Tag(name = "Import Data", description = "Import Data from Github")
@RestController
@Slf4j
@RequestMapping(path = "/import")
public class ImportGithubController {
    private final ImportService importService;
    private final HierarchyProductServiceImpl hierarchyProductSvc;
    private final HierarchyGsbpmServiceImpl hierarchyGsbpmSvc;
    private final HierarchyUserServiceImpl hierarchyUserSvc;
    private final HierarchySvcServiceImpl hierarchyServiceSvc;
    private final FunctionService functionService;

    public ImportGithubController(ImportService importService, HierarchyProductServiceImpl hierarchyProductSvc, HierarchyGsbpmServiceImpl hierarchyGsbpmSvc,
                                  HierarchyUserServiceImpl hierarchyUserSvc, HierarchySvcServiceImpl hierarchyServiceSvc, FunctionService functionService) {
        this.importService = importService;
        this.hierarchyProductSvc = hierarchyProductSvc;
        this.hierarchyGsbpmSvc = hierarchyGsbpmSvc;
        this.hierarchyUserSvc = hierarchyUserSvc;
        this.hierarchyServiceSvc = hierarchyServiceSvc;
        this.functionService = functionService;
    }

    @Operation(summary = "Import Functions")
    @GetMapping(path = "/functions")
    public String importFunctions() throws IOException {
        return functionService.importListFunctions();
    }

    @Operation(summary = "Import GSBPM")
    @GetMapping(path = "/hierarchy/gsbpm")
    public String importGsbpm() throws IOException {
        return hierarchyGsbpmSvc.importHierarchy();
    }

    @Operation(summary = "Import Services")
    @GetMapping(path = "/hierarchy/services")
    public String importServices() throws IOException {
        return hierarchyServiceSvc.importHierarchy();
    }

    @Operation(summary = "Import Products")
    @GetMapping(path = "/hierarchy/products")
    public String importProducts() throws IOException {
        return hierarchyProductSvc.importHierarchy();
    }

    @Operation(summary = "Import Users")
    @GetMapping(path = "/hierarchy/user")
    public String importUsers() throws IOException {
        return hierarchyUserSvc.importHierarchy();
    }

    @Operation(summary = "Import All")
    @GetMapping(path = "/import-hierarchy-and-functions")
    public String importHierarchyAndFunction() throws IOException {
        return importService.importHierarchyAndFunction();
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(FunctionValidationException.class)
    public ErrorResponse handleFunctionValidationException(FunctionValidationException ex) {
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), ex.getErrorMessages());
    }
}
