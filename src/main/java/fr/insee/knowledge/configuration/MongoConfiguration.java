package fr.insee.knowledge.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import fr.insee.knowledge.openapi.OpenApiConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//TODO handle case when error occurred with connexion to db

@Configuration
public class MongoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(MongoConfiguration.class);


    @Value("${mongodb.database}")
    private String database;
    @Value("${mongodb.uri}")
    private String mongoUri;

    private MongoClient mongoClient() {
        logger.info("Create mongoClient");
        return MongoClients.create(mongoUri);
    }

    @Bean(name = "mongoDatabase")
    public MongoDatabase mongoDatabase() {
        logger.info("Connection to database");
        return mongoClient().getDatabase(database);
    }

}