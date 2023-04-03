package fr.insee.knowledge.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.dao.generic.DAO;
import fr.insee.knowledge.domain.hierarchy.Hierarchy;
import fr.insee.knowledge.service.GenericHierarchyService;
import org.springframework.core.GenericTypeResolver;

import java.io.IOException;
import java.net.URL;

public class GenericHierarchyServiceImpl<T extends Hierarchy> implements GenericHierarchyService<T> {
    private DAO<T> hierarchyDAO;

    private final ObjectMapper mapper;

    private String githubRepository;

    public GenericHierarchyServiceImpl(DAO<T> hierarchyDAO, String githubRepository) {
        this.hierarchyDAO = hierarchyDAO;
        this.githubRepository = githubRepository;
        this.mapper = new ObjectMapper();
    }

    @Override
    public T getHierarchy() {
        return hierarchyDAO.findById(Constants.idUsersDocument);
    }

    @Override
    public String importHierarchy() throws IOException {
        Class<T> tClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), GenericHierarchyServiceImpl.class);
        T hierarchy = mapper.readValue(new URL(githubRepository + Constants.GithubUserFile), tClass);
        return hierarchyDAO.insertOrReplaceOne(hierarchy);
    }

    //TODO
    @Override
    public Boolean isHierarchyExist(String id) {
        return null;
    }
}
