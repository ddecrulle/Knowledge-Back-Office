package fr.insee.knowledge.controller.hierarchy;

import fr.insee.knowledge.domain.hierarchy.*;
import fr.insee.knowledge.service.HierarchyGsbpmSvc;
import fr.insee.knowledge.service.HierarchyProductSvc;
import fr.insee.knowledge.service.HierarchyServiceSvc;
import fr.insee.knowledge.service.HierarchyUserSvc;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Hierarchy", description = "")
@RestController
@RequestMapping(path = "/hierarchy")
public class HierarchyController {

    private final static Logger logger = LoggerFactory.getLogger(HierarchyController.class);

    @Autowired
    private HierarchyProductSvc hierarchyProductSvc;
    @Autowired
    private HierarchyUserSvc hierarchyUserSvc;
    @Autowired
    private HierarchyGsbpmSvc hierarchyGsbpmSvc;
    @Autowired
    private HierarchyServiceSvc hierarchyServiceSvc;

    @Operation(summary = "Get Products")
    @GetMapping(path = "/products")
    public ResponseEntity<HierarchyProduct> getProducts() {
        HierarchyProduct result = hierarchyProductSvc.getProducts();
        return new ResponseEntity<HierarchyProduct>(result, HttpStatus.OK);
    }

    @Operation(summary = "Get Gsbpm")
    @GetMapping(path = "/gsbpm")
    public ResponseEntity<HierarchyGsbpm> getGsbpm() {
        HierarchyGsbpm result = hierarchyGsbpmSvc.getGsbpm();
        return new ResponseEntity<HierarchyGsbpm>(result, HttpStatus.OK);
    }

    @Operation(summary = "Get Services")
    @GetMapping(path = "/services")
    public ResponseEntity<HierarchyService> getServices() {
        HierarchyService result = hierarchyServiceSvc.getService();
        return new ResponseEntity<HierarchyService>(result, HttpStatus.OK);
    }

    @Operation(summary = "Get Users")
    @GetMapping(path = "/users")
    public ResponseEntity<HierarchyUser> getUsers() {
        HierarchyUser result = hierarchyUserSvc.getUser();
        return new ResponseEntity<HierarchyUser>(result, HttpStatus.OK);
    }
}
