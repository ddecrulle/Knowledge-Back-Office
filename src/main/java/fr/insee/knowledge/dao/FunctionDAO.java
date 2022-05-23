package fr.insee.knowledge.dao;

import com.mongodb.MongoBulkWriteException;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.model.WriteModel;
import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.domain.Function;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Component
public class FunctionDAO extends GenericDAO {

    private final static Logger LOGGER = LoggerFactory.getLogger(FunctionDAO.class);

    @Autowired
    private MongoDatabase mongoDatabase;

    private MongoCollection<Document> mongoCollection;

    @PostConstruct
    public void init() {
        mongoCollection = mongoDatabase.getCollection(Constants.CollectionFunctions);
    }

    public FunctionDAO() {
        super(Constants.CollectionFunctions);
    }


//    public String insertOrReplaceManyFunctions(List<Function> functions) {
//        try {
//            List<WriteModel<Function>> bulkOperations = new ArrayList<>();
//            functions.forEach(
//                    function -> bulkOperations.insert(function)
//            );
//            BulkWriteResult result = mongoCollection.bulkWrite(bulkOperations);
//            return ("Success ! There was " + "\n inserted function : " + (result.getInsertedCount() + result.getUpserts().size()) +
//                    "\nupdated function : " + result.getModifiedCount() +
//                    "\ndeleted function : " + result.getDeletedCount());
//        } catch (MongoBulkWriteException exception) {
//            LOGGER.error(String.valueOf(exception));
//            return ("A Mongo BulkWriteException occured with the following error : " + exception);
//        }
//    }
}
