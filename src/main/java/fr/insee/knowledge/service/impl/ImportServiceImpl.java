package fr.insee.knowledge.service.impl;

import fr.insee.knowledge.service.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

//TODO Catch and log all exception

@Service
public class ImportServiceImpl implements ImportService {

    private final FunctionService functionService;
    private final HierarchySvcServiceImpl hierarchyServiceSvc;
    private final HierarchyUserServiceImpl hierarchyUserSvc;
    private final HierarchyGsbpmServiceImpl hierarchyGsbpmSvc;
    private final HierarchyProductServiceImpl hierarchyProductSvc;

    public ImportServiceImpl(FunctionService functionService, HierarchySvcServiceImpl hierarchyServiceSvc, HierarchyUserServiceImpl hierarchyUserSvc,
                             HierarchyGsbpmServiceImpl hierarchyGsbpmSvc, HierarchyProductServiceImpl hierarchyProductSvc) {
        this.functionService = functionService;
        this.hierarchyServiceSvc = hierarchyServiceSvc;
        this.hierarchyUserSvc = hierarchyUserSvc;
        this.hierarchyGsbpmSvc = hierarchyGsbpmSvc;
        this.hierarchyProductSvc = hierarchyProductSvc;
    }

    public String importHierarchyAndFunction() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(hierarchyGsbpmSvc.importHierarchy());
        stringBuilder.append(hierarchyProductSvc.importHierarchy());
        stringBuilder.append(hierarchyUserSvc.importHierarchy());
        stringBuilder.append(hierarchyServiceSvc.importHierarchy());
        stringBuilder.append(functionService.importListFunctions());
        return stringBuilder.toString();
    }

}
