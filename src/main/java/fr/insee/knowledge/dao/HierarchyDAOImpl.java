package fr.insee.knowledge.dao;

import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.dao.generic.DAO;
import fr.insee.knowledge.domain.Hierarchy;
import org.springframework.stereotype.Component;

@Component
public class HierarchyDAOImpl extends DAO<Hierarchy> implements HierarchyDAO {
    public HierarchyDAOImpl() {
        super(Hierarchy.class, Constants.CollectionHierarchy);
    }

}
