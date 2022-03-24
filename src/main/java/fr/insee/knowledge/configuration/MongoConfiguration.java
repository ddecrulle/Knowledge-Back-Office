package fr.insee.knowledge.configuration;

import com.mongodb.MongoCommandException;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.ValidationOptions;
import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.controller.KnowledgeImportGithub;
import fr.insee.knowledge.utils.Utils;
import org.apache.commons.io.IOUtils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

//TODO handle case when error occurred with connexion to db
@Configuration
public class MongoConfiguration {
    @Value("${mongodb.uri}")
    private String uri;
    @Value("${mongodb.database}")
    private String database;

    private final static Logger LOGGER = LoggerFactory.getLogger(MongoConfiguration.class);

    private MongoClient mongoClient() {
        return MongoClients.create(uri);
    }

    @Bean(name = "mongoDatabase")
    public MongoDatabase mongoDatabase() {
        return mongoClient().getDatabase(database);
    }

    private CreateCollectionOptions getValidateOption(String filename) throws IOException {
        Document doc = Document.parse(Utils.readFileFromResources("/schema/" + filename));
        ValidationOptions validationOptions = new ValidationOptions();
        validationOptions.validator(doc);
        CreateCollectionOptions collectionOptions = new CreateCollectionOptions();
        collectionOptions.validationOptions(validationOptions);
        return collectionOptions;
    }

    @Bean(name = "mongoListCollections")
    public ListCollectionsIterable<Document> listCollections() throws IOException {
        try {
            mongoDatabase().createCollection(Constants.CollectionFunctions, getValidateOption("schemaFunctions.json"));
            mongoDatabase().createCollection(Constants.CollectionHierarchy, getValidateOption("schemaHierarchy.json"));
        } catch (MongoCommandException e) {
            LOGGER.info("Collections already exists");
        }
        return mongoDatabase().listCollections();
    }


}