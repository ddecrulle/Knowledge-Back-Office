package fr.insee.knowledge.controller.hierarchy;

import fr.insee.knowledge.domain.hierarchy.*;
import fr.insee.knowledge.service.GenericHierarchyService;
import fr.insee.knowledge.service.impl.HierarchyGsbpmServiceImpl;
import fr.insee.knowledge.service.impl.HierarchyProductServiceImpl;
import fr.insee.knowledge.service.impl.HierarchySvcServiceImpl;
import fr.insee.knowledge.service.impl.HierarchyUserServiceImpl;
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

public class GenericHierarchyController<T extends Hierarchy> {
    private final GenericHierarchyService<T> hierarchyService;

    public GenericHierarchyController(GenericHierarchyService<T> hierarchyService) {
        this.hierarchyService = hierarchyService;
    }

    public ResponseEntity<T> getHierarchy() {
        return new ResponseEntity<T>(hierarchyService.getHierarchy(), HttpStatus.OK);
    }


}
