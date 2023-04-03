package fr.insee.knowledge.controller.hierarchy;

import fr.insee.knowledge.domain.hierarchy.HierarchySvc;
import fr.insee.knowledge.service.impl.HierarchySvcServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Hierarchy", description = "")
@RestController
@RequestMapping(path = "/hierarchy")
public class HierarchyServiceController extends GenericHierarchyController<HierarchySvc>{

    private final static Logger logger = LoggerFactory.getLogger(HierarchyServiceController.class);

    public HierarchyServiceController(HierarchySvcServiceImpl hierarchyService) {
        super(hierarchyService);
    }

    @Operation(summary = "Get Services")
    @GetMapping(path = "/services")
    public ResponseEntity<HierarchySvc> getServices() {
        return getHierarchy();
    }
}
