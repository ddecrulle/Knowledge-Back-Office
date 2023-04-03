package fr.insee.knowledge.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.dao.HierarchyGsbpmDAO;
import fr.insee.knowledge.domain.hierarchy.HierarchyGsbpm;
import fr.insee.knowledge.domain.hierarchy.HierarchyProduct;
import fr.insee.knowledge.domain.hierarchy.HierarchyUser;
import fr.insee.knowledge.service.HierarchyGsbpmSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static fr.insee.knowledge.constants.Constants.*;

@Service
public class HierarchyGsbpmSvcImpl implements HierarchyGsbpmSvc {

    @Autowired
    private HierarchyGsbpmDAO hierarchyGsbpmDAO;

    private final ObjectMapper mapper = new ObjectMapper();

    @Value("${fr.insee.knowledge.git.access.rawrepository}")
    private String githubRepository;

    @Override
    public HierarchyGsbpm getGsbpm() {
        return hierarchyGsbpmDAO.findById(idServicesDocument);
    }

    @Override
    public String importGsbpm() throws IOException {
        HierarchyGsbpm hierarchyGsbpm = mapper.readValue(new URL(githubRepository + GithubGsbpmFile), HierarchyGsbpm.class);
        return hierarchyGsbpmDAO.insertOrReplaceOne(hierarchyGsbpm);
    }

    //TODO
    @Override
    public Boolean isGsbpmExist(String id) {
        return null;
    }
}
