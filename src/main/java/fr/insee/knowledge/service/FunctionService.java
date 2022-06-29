package fr.insee.knowledge.service;

import fr.insee.knowledge.domain.Function;

import java.util.List;

public interface FunctionService {

    Function getFunctionById(String id);

    List<Function> getAllFunctions();
}
