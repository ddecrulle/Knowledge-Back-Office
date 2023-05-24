package fr.insee.knowledge.controller.hierarchy;

import fr.insee.knowledge.domain.hierarchy.HierarchyProduct;
import fr.insee.knowledge.service.impl.HierarchyProductServiceImpl;
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
public class HierarchyProductController extends GenericHierarchyController<HierarchyProduct> {
    public HierarchyProductController(HierarchyProductServiceImpl hierarchyService) {
        super(hierarchyService);
    }

    @Operation(summary = "Get Products")
    @GetMapping(path = "/products")
    public ResponseEntity<HierarchyProduct> getProducts() {
        return getHierarchy();
    }
}
