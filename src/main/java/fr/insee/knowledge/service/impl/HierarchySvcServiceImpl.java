package fr.insee.knowledge.service.impl;

import fr.insee.knowledge.dao.impl.HierarchySvcDAOImpl;
import fr.insee.knowledge.domain.hierarchy.HierarchySvc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HierarchySvcServiceImpl extends GenericHierarchyServiceImpl<HierarchySvc> {
    public HierarchySvcServiceImpl(HierarchySvcDAOImpl hierarchyDAO, @Value("${fr.insee.knowledge.git.access.rawrepository}") String githubRepository) {
        super(hierarchyDAO, githubRepository);
    }
}
