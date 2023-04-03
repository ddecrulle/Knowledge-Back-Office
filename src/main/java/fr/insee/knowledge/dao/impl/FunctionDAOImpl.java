package fr.insee.knowledge.dao.impl;

import fr.insee.knowledge.constants.Constants;
import fr.insee.knowledge.dao.FunctionDAO;
import fr.insee.knowledge.dao.generic.DAO;
import fr.insee.knowledge.domain.Function;
import org.springframework.stereotype.Component;

@Component
public class FunctionDAOImpl extends DAO<Function> implements FunctionDAO {
    public FunctionDAOImpl() {
        super(Function.class, Constants.CollectionFunctions);
    }

}
