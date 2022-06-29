package fr.insee.knowledge.controller.hierarchy;

import fr.insee.knowledge.domain.Hierarchy;
import fr.insee.knowledge.service.HierarchyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Hierarchy", description = "")
@RestController
@RequestMapping(path = "/hierarchy")
public class HierarchyController {

    private final static Logger logger = LoggerFactory.getLogger(HierarchyController.class);

    @Autowired
    private HierarchyService hierarchyService;

    @Operation(summary = "Get Hierarchy by id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Hierarchy> getHierarchyById(@PathVariable(value = "id") String id) {
        Hierarchy result = hierarchyService.getHierarchyById(id);
        return new ResponseEntity<Hierarchy>(result, HttpStatus.OK);
    }

    @Operation(summary = "Get all hierarchies")
    @GetMapping(path = "/all")
    public ResponseEntity<List<Hierarchy>> getAllHierarchies() {
        List<Hierarchy> result = hierarchyService.getAllHierarchies();
        return new ResponseEntity<List<Hierarchy>>(result, HttpStatus.OK);
    }
}
