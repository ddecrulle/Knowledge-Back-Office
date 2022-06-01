package fr.insee.knowledge.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.dao.FunctionDAO;
import fr.insee.knowledge.dao.HierarchyDAO;
import fr.insee.knowledge.domain.Function;
import fr.insee.knowledge.domain.ServiceBpmn;
import fr.insee.knowledge.service.ImportService;
import fr.insee.knowledge.utils.Utils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//TODO Catch and log all exception
@Service
public class ImportServiceImpl implements ImportService {

    private final static Logger logger = LoggerFactory.getLogger(ImportServiceImpl.class);

    @Autowired
    private FunctionDAO functionDAO;

    @Autowired
    private HierarchyDAO hierarchyDAO;

    @Value("${fr.insee.knowledge.git.access.rawrepository}")
    private String githubRepository;

    public String importHierarchy(String filename) throws IOException {
        String strHierarchy = Utils.readFileFromUrl(new URL(githubRepository + filename));
        Document document = Document.parse(strHierarchy);
        return hierarchyDAO.insertOrReplaceOneDocument(document);
    }

    public String importListFunctions(String filename) throws IOException {
        String strFunctions = Utils.readFileFromUrl(new URL(githubRepository + filename));
        List<Function> listFunctions = getListFunctionsFromJsonData(strFunctions);
        return functionDAO.insertOrReplaceManyFunctions(listFunctions);
    }

    public List<String> importHierarchyAndFunction() throws IOException {
        List<String> results = new ArrayList<String>();
        Constants.ListHierarchy.forEach(filename -> {
            try {
                results.add(filename + " " + importHierarchy(filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        results.add(Constants.GithubFunctionFile + " " + importListFunctions(Constants.GithubFunctionFile));
        return results;
    }
    
    private List<Function> getListFunctionsFromJsonData(String jsonContent) throws JsonProcessingException {
        List<Function> listFunction = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonContent);
        if (rootNode.isArray()) {
            for (JsonNode node : rootNode) {
                recursiveMapping(listFunction, node, new ServiceBpmn());
            }
        }
        return listFunction;
    }

    private static void recursiveMapping(List<Function> functionList, JsonNode jsonNode, ServiceBpmn currentService) {
        currentService.setId(jsonNode.get(Constants.idField).asText());
        currentService.setLabel(jsonNode.get(Constants.labelField).asText());

        JsonNode functionNodeArray = jsonNode.get(Constants.functionField);
        if (functionNodeArray != null) {
            for (JsonNode functionNode : functionNodeArray) {
                Function function = new Function();
                function.setLabel(functionNode.get(Constants.labelField).asText());
                // ...
                function.setServiceBpmn(currentService);
                functionList.add(function);
            }
        }
        JsonNode node = jsonNode.get(Constants.serviceField);
        if (node != null) {
            for (JsonNode serviceNode : node) {
                ServiceBpmn service = new ServiceBpmn();
                //TODO test if service exist in database
                service.setServiceBpmn(currentService);
                recursiveMapping(functionList, serviceNode, service);
            }
        }
    }

}
