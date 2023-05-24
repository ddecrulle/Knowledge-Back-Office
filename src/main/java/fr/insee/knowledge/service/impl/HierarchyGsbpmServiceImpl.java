package fr.insee.knowledge.service.impl;

import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.dao.impl.HierarchyGsbpmDAOImpl;
import fr.insee.knowledge.domain.hierarchy.HierarchyGsbpm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HierarchyGsbpmServiceImpl extends GenericHierarchyServiceImpl<HierarchyGsbpm> {

    public HierarchyGsbpmServiceImpl(HierarchyGsbpmDAOImpl hierarchyDAO, @Value("${fr.insee.knowledge.git.access.rawrepository}") String githubRepository) {
        super(hierarchyDAO, Constants.idGsbpmDocument, Constants.GithubGsbpmFile, githubRepository);
    }
}
