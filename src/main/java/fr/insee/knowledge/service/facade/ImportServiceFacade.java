package fr.insee.knowledge.service.facade;

import fr.insee.knowledge.dao.FunctionDAO;
import fr.insee.knowledge.dao.HierarchyDAO;
import fr.insee.knowledge.service.ImportFunctionService;
import fr.insee.knowledge.service.ImportHierarchyService;
import fr.insee.knowledge.service.ImportService;
import fr.insee.knowledge.service.impl.ImportFunctionServiceImpl;
import fr.insee.knowledge.service.impl.ImportHierarchyServiceImpl;
import fr.insee.knowledge.service.impl.ImportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ImportServiceFacade implements ImportHierarchyService, ImportFunctionService, ImportService {

    @Autowired
    private FunctionDAO functionDAO;

    @Autowired
    private HierarchyDAO hierarchyDAO;

    @Value("${fr.insee.knowledge.git.access.rawrepository}")
    private String githubRepository;

    private ImportServiceImpl importService;

    @Override
    public String importHierarchy(String pathName) throws IOException {
        ImportHierarchyService importHierarchyService = new ImportHierarchyServiceImpl(hierarchyDAO, githubRepository);
        return importHierarchyService.importHierarchy(pathName);
    }

    @Override
    public String importListFunctions(String pathName) throws IOException {
        ImportFunctionService importFunctionService = new ImportFunctionServiceImpl(functionDAO, githubRepository);
        return importFunctionService.importListFunctions(pathName);
    }

    @Override
    public List<String> importHierarchyAndFunction() throws IOException {
        ImportService importService = new ImportServiceImpl(functionDAO, hierarchyDAO, githubRepository);
        return importService.importHierarchyAndFunction();
    }
}
