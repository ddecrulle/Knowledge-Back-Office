package fr.insee.knowledge.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.dao.generic.DAO;
import fr.insee.knowledge.domain.hierarchy.Hierarchy;
import fr.insee.knowledge.service.GenericHierarchyService;
import org.springframework.core.GenericTypeResolver;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class GenericHierarchyServiceImpl<T extends Hierarchy> implements GenericHierarchyService<T> {
    private final DAO<T> hierarchyDAO;

    private final String idHierarchy;

    private final ObjectMapper mapper;
    private final String githubFileName;

    private String githubRepository;

    public GenericHierarchyServiceImpl(DAO<T> hierarchyDAO, String idHierarchy, String githubFileName, String githubRepository) {
        this.hierarchyDAO = hierarchyDAO;
        this.idHierarchy = idHierarchy;
        this.githubFileName = githubFileName;
        this.githubRepository = githubRepository;
        this.mapper = new ObjectMapper();
    }

    @Override
    public T getHierarchy() {
        return findHierarchyById(idHierarchy);
    }

    @Override
    public String importHierarchy() throws IOException {
        Class<T> tClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), GenericHierarchyServiceImpl.class);
        T hierarchy = mapper.readValue(new URL(githubRepository + githubFileName), tClass);
        return hierarchyDAO.insertOrReplaceOne(hierarchy);
    }

    @Override
    public T findHierarchyById(String id) {
        return hierarchyDAO.findById(id);
    }
}
