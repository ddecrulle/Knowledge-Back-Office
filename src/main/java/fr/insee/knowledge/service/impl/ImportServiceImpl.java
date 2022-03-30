package fr.insee.knowledge.service.impl;

import fr.insee.knowledge.repository.FunctionDAO;
import fr.insee.knowledge.repository.HierarchyDAO;
import fr.insee.knowledge.service.ImportService;
import fr.insee.knowledge.utils.Utils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

//TODO Catch and log all exception
@Service
public class ImportServiceImpl implements ImportService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ImportServiceImpl.class);

    @Autowired
    private FunctionDAO functionDAO;

    @Autowired
    private HierarchyDAO hierarchyDAO;

    @Value("${fr.insee.knowledge.git.access.rawrepository}")
    private String githubRepository;

    public String importHierarchy(String filename) throws IOException {
        String strHierarchy = Utils.readFileFromUrl(new URL(githubRepository + filename));
        Document document = Document.parse(strHierarchy);
        return HierarchyDAO.insertOrReplaceOneDocument(document);
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
