package fr.insee.knowledge.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//TODO handle case when error occurred with connexion to db

@Configuration
public class MongoConfiguration {

    @Value("${mongodb.database}")
    private String database;
    @Value("${mongodb.username}")
    private String username;
    @Value("${mongodb.password}")
    private String password;
    @Value("${mongodb.host}")
    private String host;

    private final static Logger LOGGER = LoggerFactory.getLogger(MongoConfiguration.class);


    private MongoClient mongoClient() {
        String mongoUri = String.format("mongodb://%s:%s@%s:27017/%s?authSource=%s", username, password, host, database, database);
        LOGGER.info(String.format("MongoURI : %s", mongoUri));
        return MongoClients.create(mongoUri);
    }

    @Bean(name = "mongoDatabase")
    public MongoDatabase mongoDatabase() {
        return mongoClient().getDatabase(database);
    }

}