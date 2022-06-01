package fr.insee.knowledge.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface ImportService {

    String importHierarchy(String pathName) throws IOException;

    String importListFunctions(String pathName) throws IOException;

    List<String> importHierarchyAndFunction() throws IOException;


}
