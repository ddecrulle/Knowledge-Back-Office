package fr.insee.knowledge.dao;

import com.mongodb.client.MongoDatabase;
import fr.insee.knowledge.constants.Constants;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HierarchyDAO extends GenericDAO {
    private final static Logger LOGGER = LoggerFactory.getLogger(HierarchyDAO.class);

    @Autowired
    private MongoDatabase mongoDatabase;

    public HierarchyDAO() {
        super(Constants.CollectionHierarchy);
    }

    public String insertHierarchy(Document hierarchy) {
        LOGGER.info("Insert Hierarchy");
        return this.insertOrReplaceOneDocument(hierarchy);
    }

}
