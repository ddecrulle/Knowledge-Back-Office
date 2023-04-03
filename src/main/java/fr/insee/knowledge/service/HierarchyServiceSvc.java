package fr.insee.knowledge.service;

import fr.insee.knowledge.domain.hierarchy.HierarchyService;

import java.io.IOException;

public interface HierarchyServiceSvc {

    HierarchyService getService();

    String importService() throws IOException;

    Boolean isServiceExist(String id);
}
