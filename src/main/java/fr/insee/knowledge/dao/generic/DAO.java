package fr.insee.knowledge.dao.generic;

import com.mongodb.MongoBulkWriteException;
import com.mongodb.MongoException;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.model.WriteModel;
import fr.insee.knowledge.domain.GenericIDLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * @param <T> the type of the entity, it extends GenericIDLabel
 */
public class DAO<T extends GenericIDLabel> implements IDao<T> {

    private final static Logger LOGGER = LoggerFactory.getLogger(DAO.class);

    @Autowired
    private MongoDatabase mongoDatabase;
    protected MongoCollection<T> mongoCollection;
    protected Class<T> entityClass;
    private String collectionName;

    /**
     * Create a new BasicDAO
     *
     * @param entityClass    the class of the POJO to persist using this DAO
     * @param collectionName the name of the collection to persist entity
     */
    public DAO(final Class<T> entityClass, final String collectionName) {
        this.entityClass = entityClass;
        this.collectionName = collectionName;
    }

    @PostConstruct
    protected void init() {
        mongoCollection = mongoDatabase.getCollection(collectionName, entityClass);
    }

    public String insertOrReplaceOne(T document) {
        try {
            mongoCollection.replaceOne(eq("_id", document.getId()), document, new ReplaceOptions().upsert(true));
            return ("Success! The document is imported in the database \n");
        } catch (MongoException exception) {
            return ("Error ! Unable to insert document : " + document.getId() + " to an error: " + exception);

        }
    }


    public String insertOrReplaceMany(List<T> documents) {
        try {
            List<WriteModel<T>> bulkOperations = new ArrayList<>();
            documents.forEach(
                    document -> bulkOperations.add(new ReplaceOneModel<T>(
                            eq("_id", document.getId()),
                            document,
                            new ReplaceOptions().upsert(true)))
            );
            BulkWriteResult result = mongoCollection.bulkWrite(bulkOperations);
            return ("Success ! There was :" + "\n inserted " + this.collectionName + " : " + (result.getInsertedCount() + result.getUpserts().size()) +
                    "\nupdated " + this.collectionName + " : " + result.getModifiedCount() +
                    "\ndeleted " + this.collectionName + " : " + result.getDeletedCount());
        } catch (MongoBulkWriteException exception) {
            LOGGER.error(String.valueOf(exception));
            return ("A Mongo BulkWriteException occured with the following error : " + exception);
        }
    }

    public FindIterable<T> findByKeyValue(String key, String value) {
        FindIterable<T> iterable = mongoCollection.find(eq(key, value));
        return iterable;
    }

    public T FindById(String value) {
        return findByKeyValue("_id", value).first();
    }

    public List<T> getAllDocuments() {
        List<T> results = new ArrayList<>();
        FindIterable<T> iterable = mongoCollection.find();
        iterable.into(results);
        return results;
    }
}