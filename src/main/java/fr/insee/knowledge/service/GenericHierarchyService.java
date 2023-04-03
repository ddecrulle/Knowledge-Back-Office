package fr.insee.knowledge.service;

import fr.insee.knowledge.domain.hierarchy.Hierarchy;

import java.io.IOException;

public interface GenericHierarchyService<T extends Hierarchy> {
    T getHierarchy();

    String importHierarchy() throws IOException;

    Boolean isHierarchyExist(String id);
}
