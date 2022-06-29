package fr.insee.knowledge.service.impl;

import fr.insee.knowledge.dao.HierarchyDAO;
import fr.insee.knowledge.domain.Hierarchy;
import fr.insee.knowledge.service.HierarchyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HierarchyServiceImpl implements HierarchyService {
    @Autowired
    private HierarchyDAO hierarchyDAO;

    public Hierarchy getHierarchyById(String idValue) {
        return hierarchyDAO.FindById(idValue);
    }

    public List<Hierarchy> getAllHierarchies() {
        return hierarchyDAO.getAllDocuments();
    }

    public Boolean isServiceExist(String id) {
        //TODO: implement
        return true;
    }
}
