package fr.insee.knowledge.dao.impl;

import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.dao.HierarchyUserDAO;
import fr.insee.knowledge.dao.generic.DAO;
import fr.insee.knowledge.domain.hierarchy.HierarchyUser;
import org.springframework.stereotype.Component;

@Component
public class HierarchyUserDAOImpl extends DAO<HierarchyUser> implements HierarchyUserDAO {
    public HierarchyUserDAOImpl() {
        super(HierarchyUser.class, Constants.CollectionHierarchy);
    }

}
