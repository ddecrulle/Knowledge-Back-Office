package fr.insee.knowledge.repository;

import com.mongodb.MongoBulkWriteException;
import com.mongodb.MongoException;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.model.WriteModel;
import fr.insee.knowledge.constants.Constants;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class GenericDAO {
    private final static Logger LOGGER = LoggerFactory.getLogger(GenericDAO.class);

    @Autowired
    private MongoDatabase mongoDatabase;

    private String CollectionName;

    public GenericDAO(String CollectionName) {
        this.CollectionName = CollectionName;
    }

    private static MongoCollection<Document> mongoCollection;


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
            LOGGER.info(String.valueOf(result));
            return ("Success ! There was " + "\ninserted function: " + (result.getInsertedCount() + result.getUpserts().size()) +
                    "\nupdated function: " + result.getModifiedCount() +
                    "\ndeleted function: " + result.getDeletedCount());
        } catch (MongoBulkWriteException exception) {
            LOGGER.error(String.valueOf(exception));
            return ("A Mongo BulkWriteException occured with the following error : " + exception);
        }
    }


}
