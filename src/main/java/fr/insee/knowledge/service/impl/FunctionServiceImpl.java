package fr.insee.knowledge.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.dao.FunctionDAO;
import fr.insee.knowledge.dao.impl.HierarchyGsbpmDAOImpl;
import fr.insee.knowledge.dao.impl.HierarchyProductDAOImpl;
import fr.insee.knowledge.dao.impl.HierarchySvcDAOImpl;
import fr.insee.knowledge.dao.impl.HierarchyUserDAOImpl;
import fr.insee.knowledge.domain.Function;
import fr.insee.knowledge.domain.GenericIDLabel;
import fr.insee.knowledge.domain.RawFunction;
import fr.insee.knowledge.domain.hierarchy.HierarchyGsbpm;
import fr.insee.knowledge.domain.hierarchy.HierarchyProduct;
import fr.insee.knowledge.domain.hierarchy.HierarchyUser;
import fr.insee.knowledge.service.FunctionService;
import fr.insee.knowledge.service.exceptions.FunctionValidationException;
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

    @Autowired
    private HierarchyGsbpmDAOImpl gsbpmDAO;

    @Autowired
    private HierarchyProductDAOImpl productDAO;

    @Autowired
    private HierarchyUserDAOImpl userDAO;

    @Autowired
    private HierarchySvcDAOImpl serviceDAO;

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
        List<Function> functions = new ArrayList<>();
        List<String> validationErrors = new ArrayList<>();
        if (!rootNode.isArray()) {
            return functions;
        }

        for (JsonNode node : rootNode) {
            fr.insee.knowledge.domain.Service service = new fr.insee.knowledge.domain.Service();
            service.setId(node.get(Constants.idField).asText());
            service.setLabel(node.get(Constants.labelField).asText());
            recursiveMapping(functions, node, service, validationErrors);
        }

        if (!validationErrors.isEmpty()) {
            throw new FunctionValidationException("Des erreurs de validation sont survenues", validationErrors);
        }
        return functions;
    }

    private void recursiveMapping(List<Function> functions, JsonNode currentServiceNode, fr.insee.knowledge.domain.Service currentService, List<String> validationErrors) throws JsonProcessingException {

        JsonNode functionsNode = currentServiceNode.get(Constants.functionField);
        addFunctionsFromService(functions, functionsNode, currentService, validationErrors);

        JsonNode subServicesNode = currentServiceNode.get(Constants.serviceField);
        if (subServicesNode == null) {
            return;
        }

        for (JsonNode subServiceNode : subServicesNode) {
            fr.insee.knowledge.domain.Service subService = new fr.insee.knowledge.domain.Service();
            subService.setId(subServiceNode.get(Constants.idField).asText());
            subService.setLabel(subServiceNode.get(Constants.labelField).asText());
            subService.setService(currentService);

            if (serviceDAO.findById(subService.getId()) == null) {
                validationErrors.add(String.format("Le service %s n'existe pas", subService.getId()));
            }
            recursiveMapping(functions, subServiceNode, subService, validationErrors);
        }
    }

    private void addFunctionsFromService(List<Function> functions, JsonNode functionsNode,
                                         fr.insee.knowledge.domain.Service service,
                                         List<String> validationErrors) throws JsonProcessingException {
        if (functionsNode == null) {
            return;
        }

        for (JsonNode functionNode : functionsNode) {
            RawFunction rawFunction = mapper.treeToValue(functionNode, RawFunction.class);
            Function function = new Function();
            function.setId(rawFunction.getId());
            function.setIdProduct(rawFunction.getIdProduct());
            function.setDispo(rawFunction.getDispo());
            function.setTasks(rawFunction.getTasks());
            function.setService(service);

            List<GenericIDLabel> products = new ArrayList<>();
            List<GenericIDLabel> users = new ArrayList<>();

            for (String idProduct : rawFunction.getProducts()) {
                HierarchyProduct product = productDAO.findById(idProduct);
                if (product == null) {
                    validationErrors.add(String.format("Le produit %s n'existe pas pour la fonction %s", idProduct, function.getId()));
                    continue;
                }
                products.add(product);
            }

            for (String idUser : rawFunction.getUsers()) {
                HierarchyUser user = userDAO.findById(idUser);
                if (user == null) {
                    validationErrors.add(String.format("L'utilisateur %s n'existe pas pour la fonction %s", idUser, function.getId()));
                    continue;
                }
                users.add(user);
            }

            String idGsbpm = rawFunction.getGsbpm();
            HierarchyGsbpm gsbpm = gsbpmDAO.findById(idGsbpm);
            if (gsbpm == null) {
                validationErrors.add(String.format("Le GSPM %s n'existe pas pour la fonction %s", idGsbpm, function.getId()));
            }

            function.setGsbpm(gsbpm);
            function.setProducts(products);
            function.setUsers(users);
            functions.add(function);
        }
    }
}
