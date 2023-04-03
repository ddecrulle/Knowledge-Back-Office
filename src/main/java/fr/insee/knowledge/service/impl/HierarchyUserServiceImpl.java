package fr.insee.knowledge.service.impl;

import fr.insee.knowledge.dao.impl.HierarchyUserDAOImpl;
import fr.insee.knowledge.domain.hierarchy.HierarchyUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HierarchyUserServiceImpl extends GenericHierarchyServiceImpl<HierarchyUser> {
    public HierarchyUserServiceImpl(HierarchyUserDAOImpl hierarchyDAO, @Value("${fr.insee.knowledge.git.access.rawrepository}") String githubRepository) {
        super(hierarchyDAO, githubRepository);
    }
}
