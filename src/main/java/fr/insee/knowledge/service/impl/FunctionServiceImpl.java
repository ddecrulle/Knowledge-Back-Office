package fr.insee.knowledge.service.impl;

import fr.insee.knowledge.dao.FunctionDAO;
import fr.insee.knowledge.service.FunctionService;
import fr.insee.knowledge.utils.Utils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

    public String importListFunctions(String filename) throws IOException {
        String strFunctions = Utils.readFileFromUrl(new URL(githubRepository + filename));
        Object object = Document.parse("{\"json\":" + strFunctions + "}").get("json");
        if (object instanceof ArrayList) {
            ArrayList<Document> documents = (ArrayList<Document>) object;
            return functionDAO.insertOrReplaceManyDocuments(documents);
        }
        if (object instanceof Document) {
            Document document = (Document) object;
            return functionDAO.insertOrReplaceOneDocument(document);
        }
        return "An error occured with data structure";
    }

}
