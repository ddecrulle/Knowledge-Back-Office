package fr.insee.knowledge.repository;

import com.mongodb.MongoBulkWriteException;
import com.mongodb.MongoException;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.model.WriteModel;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


public class GenericDAO {
    private final static Logger LOGGER = LoggerFactory.getLogger(GenericDAO.class);

    @Autowired
    private MongoDatabase mongoDatabase;

    private String CollectionName;
    private static MongoCollection<Document> mongoCollection;

    public GenericDAO(String CollectionName) {
        this.CollectionName = CollectionName;
        LOGGER.info("constructor generic");
        // mongoCollection = mongoDatabase.getCollection(CollectionName);
    }


    @PostConstruct
    public void init() {
        mongoCollection = mongoDatabase.getCollection(CollectionName);
    }

    public static String insertOrReplaceOneDocument(Document document) {
        try {
            mongoCollection.replaceOne(eq("id", document.getString("id")), document, new ReplaceOptions().upsert(true));
            return ("Success! The document is imported in the database");
        } catch (MongoException exception) {
            return ("Error ! Unable to insert document : " + document.getString("id") + " to an error: " + exception);

        }
    }

    public String insertOrReplaceManyDocuments(List<Document> documents) {
        try {
            List<WriteModel<Document>> bulkOperations = new ArrayList<>();
            documents.forEach(
                    document -> bulkOperations.add(new ReplaceOneModel<>(
                            eq("id", document.getString("id")),
                            document,
                            new ReplaceOptions().upsert(true)))
            );
            BulkWriteResult result = mongoCollection.bulkWrite(bulkOperations);
            return ("Success ! There was " + "\n inserted function : " + (result.getInsertedCount() + result.getUpserts().size()) +
                    "\nupdated function : " + result.getModifiedCount() +
                    "\ndeleted function : " + result.getDeletedCount());
        } catch (MongoBulkWriteException exception) {
            LOGGER.error(String.valueOf(exception));
            return ("A Mongo BulkWriteException occured with the following error : " + exception);
        }
    }

    public FindIterable<Document> findByKeyValue(String key, String value) {
        FindIterable<Document> iterable = mongoCollection.find(eq(key, value));
        return iterable;
    }

    public Document FindByIndex(String index, String value) {
        return findByKeyValue(index, value).first();
    }

    public List<Document> getAllDocument() {
        LOGGER.info(this.CollectionName);
        List<Document> results = new ArrayList<>();
        FindIterable<Document> iterable = mongoCollection.find();
        iterable.into(results);
        return results;
    }


}
