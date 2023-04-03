package fr.insee.knowledge.service.impl;

import fr.insee.knowledge.dao.impl.HierarchyProductDAOImpl;
import fr.insee.knowledge.domain.hierarchy.HierarchyProduct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HierarchyProductServiceImpl extends GenericHierarchyServiceImpl<HierarchyProduct> {
    public HierarchyProductServiceImpl(HierarchyProductDAOImpl hierarchyDAO, @Value("${fr.insee.knowledge.git.access.rawrepository}") String githubRepository) {
        super(hierarchyDAO, githubRepository);
    }
}
