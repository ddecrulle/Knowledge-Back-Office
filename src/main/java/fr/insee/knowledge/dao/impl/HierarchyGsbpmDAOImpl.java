package fr.insee.knowledge.dao.impl;

import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.dao.HierarchyGsbpmDAO;
import fr.insee.knowledge.dao.HierarchyProductDAO;
import fr.insee.knowledge.dao.generic.DAO;
import fr.insee.knowledge.domain.hierarchy.HierarchyGsbpm;
import fr.insee.knowledge.domain.hierarchy.HierarchyProduct;
import org.springframework.stereotype.Component;

@Component
public class HierarchyGsbpmDAOImpl extends DAO<HierarchyGsbpm> implements HierarchyGsbpmDAO {
    public HierarchyGsbpmDAOImpl() {
        super(HierarchyGsbpm.class, Constants.CollectionHierarchy);
    }

}
