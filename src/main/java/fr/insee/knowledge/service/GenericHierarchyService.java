package fr.insee.knowledge.service;

import fr.insee.knowledge.domain.hierarchy.Hierarchy;

import java.io.IOException;
import java.util.Optional;

public interface GenericHierarchyService<T extends Hierarchy> {
    T getHierarchy();

    String importHierarchy() throws IOException;

    T findHierarchyById(String id);
}
