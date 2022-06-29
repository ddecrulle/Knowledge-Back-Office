package fr.insee.knowledge.dao.generic;

import fr.insee.knowledge.dao.FunctionDAO;
import fr.insee.knowledge.dao.FunctionDAOImpl;

public class DAOFactory {
    public static FunctionDAO getFunctionDAO() {
        return new FunctionDAOImpl();
    }
}
