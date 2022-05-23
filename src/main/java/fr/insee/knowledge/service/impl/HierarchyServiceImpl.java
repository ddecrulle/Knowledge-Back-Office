package fr.insee.knowledge.service.impl;

import fr.insee.knowledge.dao.HierarchyDAO;
import fr.insee.knowledge.service.HierarchyService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HierarchyServiceImpl implements HierarchyService {
    @Autowired
    private HierarchyDAO hierarchyDAO;

    public Document getHierarchyById(String idValue) {
        return hierarchyDAO.FindByIndex("id", idValue);
    }

    public List<Document> getAllHierarchies() {
        return hierarchyDAO.getAllDocument();
    }

}
