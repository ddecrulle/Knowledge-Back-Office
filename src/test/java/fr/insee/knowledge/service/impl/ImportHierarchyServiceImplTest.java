package fr.insee.knowledge.service.impl;

import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.dao.HierarchyDAO;
import fr.insee.knowledge.service.ImportHierarchyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ImportHierarchyServiceImplTest {

    @Mock
    private HierarchyDAO hierarchyDAO;

    public void importHierarchyTest() throws IOException {
        ImportHierarchyService importHierarchy = new ImportHierarchyServiceImpl(hierarchyDAO, "https://raw.githubusercontent.com/ddecrulle/Knowledge-Data/main/");
        String result = importHierarchy.importHierarchy(Constants.GithubProductsFile);
        assertThat(result).isNotEmpty();
    }
}
