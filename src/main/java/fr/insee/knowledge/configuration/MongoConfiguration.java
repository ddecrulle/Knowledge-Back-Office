package fr.insee.knowledge.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//TODO handle case when error occurred with connexion to db

@Configuration
public class MongoConfiguration {
    @Value("${mongodb.database}")
    private static String database;
    @Value("${mongodb.username}")
    private static String username;
    @Value("${mongodb.password}")
    private static String password;
    @Value("${mongodb.host}")
    private static String host;

    private final String mongoUri = String.format("mongodb://%s:%s@%s:27017/%s?authSource=%s", username, password, host, database, database);

    private MongoClient mongoClient() {
        return MongoClients.create(mongoUri);
    }

    @Bean(name = "mongoDatabase")
    public MongoDatabase mongoDatabase() {
        return mongoClient().getDatabase(database);
    }

}