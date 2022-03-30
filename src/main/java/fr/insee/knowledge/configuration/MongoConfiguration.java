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

}