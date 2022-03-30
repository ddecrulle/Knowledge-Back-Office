package fr.insee.knowledge.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.insee.knowledge.constants.Constants;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FunctionDAO extends GenericDAO {

    private final static Logger LOGGER = LoggerFactory.getLogger(FunctionDAO.class);

    @Autowired
    private MongoDatabase mongoDatabase;

    public FunctionDAO() {
        super(Constants.CollectionFunctions);
    }


}
