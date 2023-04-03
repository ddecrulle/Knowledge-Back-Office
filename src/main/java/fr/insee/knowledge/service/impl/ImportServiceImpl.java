package fr.insee.knowledge.service.impl;

import fr.insee.knowledge.service.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

//TODO Catch and log all exception

@Service
public class ImportServiceImpl implements ImportService {

    private final FunctionService functionService;
    private final HierarchyServiceSvc hierarchyServiceSvc;
    private final HierarchyUserSvc hierarchyUserSvc;
    private final HierarchyGsbpmSvc hierarchyGsbpmSvc;
    private final HierarchyProductSvc hierarchyProductSvc;

    public ImportServiceImpl(FunctionService functionService, HierarchyServiceSvc hierarchyServiceSvc, HierarchyUserSvc hierarchyUserSvc, HierarchyGsbpmSvc hierarchyGsbpmSvc, HierarchyProductSvc hierarchyProductSvc) {
        this.functionService = functionService;
        this.hierarchyServiceSvc = hierarchyServiceSvc;
        this.hierarchyUserSvc = hierarchyUserSvc;
        this.hierarchyGsbpmSvc = hierarchyGsbpmSvc;
        this.hierarchyProductSvc = hierarchyProductSvc;
    }

    public String importHierarchyAndFunction() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(hierarchyGsbpmSvc.importGsbpm());
        stringBuilder.append(hierarchyProductSvc.importProduct());
        stringBuilder.append(hierarchyUserSvc.importUser());
        stringBuilder.append(hierarchyServiceSvc.importService());
        stringBuilder.append(functionService.importListFunctions());
        return stringBuilder.toString();
    }

}
