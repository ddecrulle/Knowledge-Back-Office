package fr.insee.knowledge.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.dao.FunctionDAO;
import fr.insee.knowledge.domain.Function;
import fr.insee.knowledge.domain.Services;
import fr.insee.knowledge.service.ImportFunctionService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//TODO Catch and log all exception


public class ImportFunctionServiceImpl implements ImportFunctionService {
    private final FunctionDAO functionDAO;
    private final String githubRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    public ImportFunctionServiceImpl(FunctionDAO functionDAO, String githubRepository) {
        this.functionDAO = functionDAO;
        this.githubRepository = githubRepository;
    }

    public String importListFunctions(String filename) throws IOException {
        JsonNode jsonNode = mapper.readTree(new URL(githubRepository + filename));
        List<Function> listFunctions = getListFunctionsFromJsonNode(jsonNode);
        return functionDAO.insertOrReplaceMany(listFunctions);
    }

    private List<Function> getListFunctionsFromJsonNode(JsonNode rootNode) throws JsonProcessingException {
        List<Function> listFunction = new ArrayList<>();
        if (rootNode.isArray()) {
            for (JsonNode node : rootNode) {
                recursiveMapping(listFunction, node, new Services());
            }
        }
        return listFunction;
    }

    private void recursiveMapping(List<Function> functionList, JsonNode jsonNode, Services currentServices) throws JsonProcessingException {
        currentServices.setId(jsonNode.get(Constants.idField).asText());
        currentServices.setLabel(jsonNode.get(Constants.labelField).asText());

        JsonNode functionNodeArray = jsonNode.get(Constants.functionField);
        if (functionNodeArray != null) {
            for (JsonNode functionNode : functionNodeArray) {
                Function function = mapper.treeToValue(functionNode, Function.class);
                function.setServiceBpmn(currentServices);
                functionList.add(function);
            }
        }
        JsonNode node = jsonNode.get(Constants.serviceField);
        if (node != null) {
            for (JsonNode serviceNode : node) {
                Services services = new Services();
                //TODO test if service exist in database
                services.setService(currentServices);
                recursiveMapping(functionList, serviceNode, services);
            }
        }
    }


}
