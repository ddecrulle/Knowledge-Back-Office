package fr.insee.knowledge.dao.impl;

import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.dao.HierarchyProductDAO;
import fr.insee.knowledge.dao.generic.DAO;
import fr.insee.knowledge.domain.hierarchy.HierarchyProduct;
import org.springframework.stereotype.Component;

@Component
public class HierarchyProductDAOImpl extends DAO<HierarchyProduct> implements HierarchyProductDAO {
    public HierarchyProductDAOImpl() {
        super(HierarchyProduct.class, Constants.CollectionHierarchy);
    }

}
