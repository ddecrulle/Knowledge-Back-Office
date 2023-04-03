package fr.insee.knowledge.service;

import fr.insee.knowledge.domain.hierarchy.HierarchyUser;

import java.io.IOException;
import java.net.MalformedURLException;

public interface HierarchyUserSvc {

    HierarchyUser getUser();

    String importUser() throws IOException;

    Boolean isUserExist(String id);
}
