package fr.insee.knowledge.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.dao.HierarchyUserDAO;
import fr.insee.knowledge.domain.hierarchy.HierarchyUser;
import fr.insee.knowledge.service.HierarchyUserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static fr.insee.knowledge.constants.Constants.GithubUserFile;
import static fr.insee.knowledge.constants.Constants.idUsersDocument;

@Service
public class HierarchyUserSvcImpl implements HierarchyUserSvc {

    @Autowired
    private HierarchyUserDAO hierarchyUserDAO;

    private final ObjectMapper mapper = new ObjectMapper();

    @Value("${fr.insee.knowledge.git.access.rawrepository}")
    private String githubRepository;

    @Override
    public HierarchyUser getUser() {
        return hierarchyUserDAO.findById(idUsersDocument);
    }

    @Override
    public String importUser() throws IOException {
        HierarchyUser hierarchyUser = mapper.readValue(new URL(githubRepository + GithubUserFile), HierarchyUser.class);
        return hierarchyUserDAO.insertOrReplaceOne(hierarchyUser);
    }

    //TODO
    @Override
    public Boolean isUserExist(String id) {
        return null;
    }
}
