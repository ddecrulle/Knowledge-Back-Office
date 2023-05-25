package fr.insee.knowledge.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.dao.FunctionDAO;
import fr.insee.knowledge.domain.Function;
import fr.insee.knowledge.domain.RawFunction;
import fr.insee.knowledge.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static fr.insee.knowledge.constants.Constants.GithubFunctionFile;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Value("${fr.insee.knowledge.git.access.rawrepository}")
    private String githubRepository;
    @Autowired
    private FunctionDAO functionDAO;
    private final ObjectMapper mapper = new ObjectMapper();

    public Function getFunctionById(String idValue) {
        return functionDAO.findById(idValue);
    }

    public List<Function> getAllFunctions() {
        return functionDAO.getAllDocuments();
    }

    public String importListFunctions() throws IOException {
        JsonNode jsonNode = mapper.readTree(new URL(githubRepository + GithubFunctionFile));
        List<Function> listFunctions = getListFunctionsFromJsonNode(jsonNode);
        return functionDAO.insertOrReplaceMany(listFunctions);
    }

    private List<Function> getListFunctionsFromJsonNode(JsonNode rootNode) throws JsonProcessingException {
        List<Function> listFunction = new ArrayList<>();
        List<RawFunction> functionInError = new ArrayList<>();
        if (rootNode.isArray()) {
            for (JsonNode node : rootNode) {
                recursiveMapping(listFunction, node, new fr.insee.knowledge.domain.Service(), functionInError);
            }
        }
        return listFunction;
    }

    private void recursiveMapping(List<Function> functionList, JsonNode jsonNode, fr.insee.knowledge.domain.Service currentService, List<RawFunction> functionInError) throws JsonProcessingException {
        currentService.setId(jsonNode.get(Constants.idField).asText());
        currentService.setLabel(jsonNode.get(Constants.labelField).asText());

        JsonNode functionNodeArray = jsonNode.get(Constants.functionField);
        if (functionNodeArray != null) {
            for (JsonNode functionNode : functionNodeArray) {
                RawFunction rawFunction = mapper.treeToValue(functionNode, RawFunction.class);
                rawFunction.setService(currentService);

                // -> get products, user, gsbpm with id in hierarchy db
                // -> map RawFunction to Function

                functionList.add(rawFunction);
            }
        }
        JsonNode node = jsonNode.get(Constants.serviceField);
        if (node != null) {
            for (JsonNode serviceNode : node) {
                fr.insee.knowledge.domain.Service service = new fr.insee.knowledge.domain.Service();
                //TODO test if service exist in database
                service.setService(currentService);
                recursiveMapping(functionList, serviceNode, service);
            }
        }
    }
}
