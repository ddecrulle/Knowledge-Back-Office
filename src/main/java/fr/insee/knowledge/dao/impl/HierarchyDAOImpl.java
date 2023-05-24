package fr.insee.knowledge.dao.impl;

import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.dao.generic.DAO;
import fr.insee.knowledge.domain.hierarchy.Hierarchy;
import org.springframework.stereotype.Component;

public class HierarchyDAOImpl<T extends Hierarchy> extends DAO<T> {
    public HierarchyDAOImpl() {
        super(Constants.CollectionHierarchy);
    }

}
