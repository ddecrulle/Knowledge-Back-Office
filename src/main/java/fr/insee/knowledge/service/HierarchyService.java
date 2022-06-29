package fr.insee.knowledge.service;

import fr.insee.knowledge.domain.Hierarchy;

import java.util.List;

public interface HierarchyService {

    Hierarchy getHierarchyById(String id);

    List<Hierarchy> getAllHierarchies();

    Boolean isServiceExist(String id);
}
