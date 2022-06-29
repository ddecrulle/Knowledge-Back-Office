package fr.insee.knowledge.service.impl;

import fr.insee.knowledge.dao.FunctionDAO;
import fr.insee.knowledge.domain.Function;
import fr.insee.knowledge.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Value("${fr.insee.knowledge.git.access.rawrepository}")
    private String githubRepository;

    @Autowired
    private FunctionDAO functionDAO;

    public Function getFunctionById(String idValue) {
        return functionDAO.FindById(idValue);
    }

    public List<Function> getAllFunctions() {
        return functionDAO.getAllDocuments();
    }


}
