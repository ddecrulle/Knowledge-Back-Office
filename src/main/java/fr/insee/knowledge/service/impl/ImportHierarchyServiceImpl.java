package fr.insee.knowledge.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.dao.HierarchyDAO;
import fr.insee.knowledge.domain.Hierarchy;
import fr.insee.knowledge.service.ImportHierarchyService;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URL;

@Slf4j
public class ImportHierarchyServiceImpl implements ImportHierarchyService {
    private final HierarchyDAO hierarchyDAO;
    private final String githubRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    public ImportHierarchyServiceImpl(HierarchyDAO hierarchyDAO, String githubRepository) {
        this.hierarchyDAO = hierarchyDAO;
        this.githubRepository = githubRepository;
    }

    public String importHierarchy(String filename) throws IOException {
        Hierarchy hierarchy = mapper.readValue(new URL(githubRepository + filename), Hierarchy.class);
        return hierarchyDAO.insertOrReplaceOne(hierarchy);
    }

}