package fr.insee.knowledge.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.dao.HierarchyServiceDAO;
import fr.insee.knowledge.domain.hierarchy.HierarchyService;
import fr.insee.knowledge.service.HierarchyServiceSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

import static fr.insee.knowledge.constants.Constants.GithubServicesFile;
import static fr.insee.knowledge.constants.Constants.idServicesDocument;

@Service
public class HierarchyServiceSvcImpl implements HierarchyServiceSvc {

    @Autowired
    private HierarchyServiceDAO hierarchyServiceDAO;

    private final ObjectMapper mapper = new ObjectMapper();

    @Value("${fr.insee.knowledge.git.access.rawrepository}")
    private String githubRepository;

    @Override
    public HierarchyService getService() {
        return hierarchyServiceDAO.findById(idServicesDocument);
    }

    @Override
    public String importService() throws IOException {
        HierarchyService hierarchyService = mapper.readValue(new URL(githubRepository + GithubServicesFile), HierarchyService.class);
        return hierarchyServiceDAO.insertOrReplaceOne(hierarchyService);
    }


    //TODO
    @Override
    public Boolean isServiceExist(String id) {
        return true;
    }
}
