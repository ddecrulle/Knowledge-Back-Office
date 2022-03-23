package fr.insee.knowledge.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.ValidationOptions;
import fr.insee.knowledge.constants.Constants;
import org.apache.commons.io.IOUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Configuration
public class MongoConfiguration {
    @Value("${mongodb.uri}")
    private String uri;
    @Value("${mongodb.database}")
    private String database;

    private MongoClient mongoClient() {
        return MongoClients.create(uri);
    }

    @Bean(name = "mongoDatabase")
    public MongoDatabase mongoDatabase() {
        return mongoClient().getDatabase(database)
    }

    private static String readFileFromResources(String fileName) throws IOException {
        return IOUtils.resourceToString(fileName, StandardCharsets.UTF_8);
    }
    private CreateCollectionOptions getValidateOption(String filename) throws IOException {
        Document doc = Document.parse(readFileFromResources("schema/" + filename ));
        ValidationOptions validationOptions = new ValidationOptions();
        validationOptions.validator(doc);
        CreateCollectionOptions collectionOptions = new CreateCollectionOptions();
        collectionOptions.validationOptions(validationOptions)
        return collectionOptions;
    }

    @Bean
    public void createCollection() throws IOException {
        mongoDatabase().createCollection(Constants.CollectionFunctions,getValidateOption("schemaFunctions.json"));
        mongoDatabase().createCollection(Constants.CollectionHierarchy,getValidateOption("schemaHierarchy.json"));
    }





}