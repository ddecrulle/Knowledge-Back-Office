package fr.insee.knowledge.service.impl;

import fr.insee.knowledge.repository.FunctionDAO;
import fr.insee.knowledge.service.FunctionService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionServiceImpl implements FunctionService {
    @Autowired
    private FunctionDAO functionDAO;

    public Document getFunctionById(String idValue) {
        return functionDAO.FindByIndex("id", idValue);
    }

    public List<Document> getAllFunctions() {
        return functionDAO.getAllDocument();
    }
}
