package fr.insee.knowledge.service;

import fr.insee.knowledge.domain.hierarchy.HierarchyGsbpm;

import java.io.IOException;

public interface HierarchyGsbpmSvc {

    HierarchyGsbpm getGsbpm();

    String importGsbpm() throws IOException;

    Boolean isGsbpmExist(String id);
}
