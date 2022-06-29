package fr.insee.knowledge.service.impl;

import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.dao.FunctionDAO;
import fr.insee.knowledge.dao.HierarchyDAO;
import fr.insee.knowledge.service.ImportFunctionService;
import fr.insee.knowledge.service.ImportHierarchyService;
import fr.insee.knowledge.service.ImportService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TODO Catch and log all exception


public class ImportServiceImpl implements ImportService {
    private final FunctionDAO functionDAO;
    private final HierarchyDAO hierarchyDAO;
    private final String githubRepository;

    private final ImportFunctionService importFunctionService;
    private final ImportHierarchyService importHierarchyService;


    public ImportServiceImpl(FunctionDAO functionDAO, HierarchyDAO hierarchyDAO, String githubRepository) {
        this.functionDAO = functionDAO;
        this.hierarchyDAO = hierarchyDAO;
        this.githubRepository = githubRepository;
        this.importFunctionService = new ImportFunctionServiceImpl(functionDAO, githubRepository);
        this.importHierarchyService = new ImportHierarchyServiceImpl(hierarchyDAO, githubRepository);
    }

    public List<String> importHierarchyAndFunction() throws IOException {
        List<String> results = new ArrayList<String>();
        Constants.ListHierarchy.forEach(filename -> {
            try {
                results.add(filename + " " + importHierarchyService.importHierarchy(filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        results.add(Constants.GithubFunctionFile + " " + importFunctionService.importListFunctions(Constants.GithubFunctionFile));
        return results;
    }

}
