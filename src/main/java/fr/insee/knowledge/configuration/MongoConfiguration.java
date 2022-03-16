package fr.insee.knowledge.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfiguration {
    @Value("${mongodb.uri}")
    private String uri;
    @Value("${mongodb.database}")
    private String database;


    @Bean(name = "mongoClient")
    public MongoClient mongoClient() {
        return MongoClients.create(uri);
    }

}