package fr.insee.knowledge.controller.hierarchy;

import fr.insee.knowledge.domain.hierarchy.HierarchyGsbpm;
import fr.insee.knowledge.service.impl.HierarchyGsbpmServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Hierarchy", description = "")
@RestController
@RequestMapping(path = "/hierarchy")
public class HierarchyGsbpmController extends GenericHierarchyController<HierarchyGsbpm> {
    public HierarchyGsbpmController(HierarchyGsbpmServiceImpl hierarchyService) {
        super(hierarchyService);
    }

    @Operation(summary = "Get Gsbpm")
    @GetMapping(path = "/gsbpm")
    public ResponseEntity<HierarchyGsbpm> getGsbpm() {
        return getHierarchy();
    }

    @Operation(summary = "Get a Sub Gsbpm by Id")
    @GetMapping(path = "/gsbpm/{id}")
    public ResponseEntity<HierarchyGsbpm> getGsbpmChildById(@PathVariable(value = "id") String id) {
        return getHierarchy();
    }


}
