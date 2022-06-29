package fr.insee.knowledge.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Configuration
public class MongoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(MongoConfiguration.class);

    private CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    private CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

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
        return mongoClient().getDatabase(database).withCodecRegistry(pojoCodecRegistry);
    }

}