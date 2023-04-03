package fr.insee.knowledge.dao.impl;

import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.dao.HierarchyServiceDAO;
import fr.insee.knowledge.dao.generic.DAO;
import fr.insee.knowledge.domain.hierarchy.HierarchyService;
import org.springframework.stereotype.Component;

@Component
public class HierarchyServiceDAOImpl extends DAO<HierarchyService> implements HierarchyServiceDAO {
    public HierarchyServiceDAOImpl() {
        super(HierarchyService.class, Constants.CollectionHierarchy);
    }

}
