package fr.insee.knowledge.service;

import java.io.IOException;
import java.util.List;

public interface ImportService {
    List<String> importHierarchyAndFunction() throws IOException;

}
