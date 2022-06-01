package fr.insee.knowledge.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.dao.FunctionDAO;
import fr.insee.knowledge.domain.Function;
import fr.insee.knowledge.service.FunctionService;
import org.bson.Document;
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

    public Document getFunctionById(String idValue) {
        return functionDAO.FindByIndex("id", idValue);
    }

    public List<Document> getAllFunctions() {
        return functionDAO.getAllDocument();
    }


}
