package fr.insee.knowledge.repository;

import com.mongodb.MongoBulkWriteException;
import com.mongodb.MongoException;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.model.WriteModel;

import static com.mongodb.client.model.Filters.eq;
import fr.insee.knowledge.constants.Constants;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class MongoDao {

    private final static Logger LOGGER = LoggerFactory.getLogger(MongoDao.class);

    @Autowired
    private MongoDatabase mongoDatabase;

    private MongoCollection<Document> functionCollection;
    private MongoCollection<Document> hierarchyCollection;

    @PostConstruct
    public void init() {
        functionCollection = mongoDatabase.getCollection(Constants.CollectionFunctions);
        hierarchyCollection = mongoDatabase.getCollection(Constants.CollectionHierarchy);
    }

    private String InsertOrReplaceOneDocument(MongoCollection<Document> mongoCollection, Document document) {
        try {
            LOGGER.info(document.getString("id"));
            mongoCollection.replaceOne(eq("id", document.getString("id")), document, new ReplaceOptions().upsert(true));
            return ("Success! The document is imported in the database");
        } catch (MongoException exception) {
            return ("Error ! Unable to insert document : " + document.getString("id") + " to an error: " + exception);

        }
    }

    private String insertOrReplaceManyDocuments(MongoCollection<Document> mongoCollection, List<Document> documents) {
        try {
            List<WriteModel<Document>> bulkOperations = new ArrayList<>();
            documents.forEach(
                    document -> bulkOperations.add(new ReplaceOneModel(
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

    public String insertFunction(Document function) {
        LOGGER.info("Insert Function");
        return InsertOrReplaceOneDocument(functionCollection, function);
    }

    public String insertListFunctions(List<Document> functions) {
        LOGGER.info("Insert ListOfFunctions");
        return insertOrReplaceManyDocuments(functionCollection, functions);
    }

    public String insertHierarchy(Document hierarchy) {
        LOGGER.info("Insert Hierarchy");
        return InsertOrReplaceOneDocument(hierarchyCollection, hierarchy);
    }


}
