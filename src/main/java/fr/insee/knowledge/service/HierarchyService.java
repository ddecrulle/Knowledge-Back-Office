package fr.insee.knowledge.service;

import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HierarchyService {

    Document getHierarchyById(String id);

    List<Document> getAllHierarchies();
}
