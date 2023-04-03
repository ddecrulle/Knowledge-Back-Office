package fr.insee.knowledge.service;

import fr.insee.knowledge.domain.Function;

import java.io.IOException;
import java.util.List;

public interface FunctionService {

    Function getFunctionById(String id);

    List<Function> getAllFunctions();

    String importListFunctions() throws IOException;

}
