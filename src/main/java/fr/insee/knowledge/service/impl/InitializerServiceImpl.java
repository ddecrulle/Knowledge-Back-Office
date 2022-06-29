package fr.insee.knowledge.service.impl;

import com.mongodb.MongoCommandException;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.ValidationOptions;
import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.service.InitializerService;
import fr.insee.knowledge.service.facade.ImportServiceFacade;
import fr.insee.knowledge.utils.Utils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class InitializerServiceImpl implements InitializerService {

    @Autowired
    private MongoDatabase mongoDatabase;

    @Autowired
    private ImportServiceFacade importService;

    private final static Logger logger = LoggerFactory.getLogger(InitializerServiceImpl.class);

    private CreateCollectionOptions getValidateOption(String filename) throws IOException {
        Document doc = Document.parse(Utils.readFileFromResources("/schema/" + filename));
        ValidationOptions validationOptions = new ValidationOptions();
        validationOptions.validator(doc);
        CreateCollectionOptions collectionOptions = new CreateCollectionOptions();
        collectionOptions.validationOptions(validationOptions);
        return collectionOptions;
    }

    public void createCollections() {
        logger.info("Create Collection");
        try {
            mongoDatabase.createCollection(Constants.CollectionFunctions, getValidateOption("schemaFunctions.json"));
            mongoDatabase.createCollection(Constants.CollectionHierarchy, getValidateOption("schemaHierarchy.json"));
            logger.info("Collections created");
        } catch (MongoCommandException | IOException e) {
            logger.info("Collections already exists");
        }
    }

    public void importDataFromGithub() throws IOException {
        logger.info("Import Data from Github");
        try {
            List<String> result = importService.importHierarchyAndFunction();
            logger.info(String.valueOf(result));
        } catch (Exception e) {
            logger.error("Error could not import data from github. Execption occured " + e);
        }
    }
}
