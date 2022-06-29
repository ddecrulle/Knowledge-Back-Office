package fr.insee.knowledge.dao.generic;

import com.mongodb.client.FindIterable;
import fr.insee.knowledge.domain.GenericIDLabel;

import java.util.List;

public interface IDao<T extends GenericIDLabel> {

    String insertOrReplaceOne(T entity);

    String insertOrReplaceMany(List<T> listEntity);

    FindIterable<T> findByKeyValue(String key, String value);

    T FindById(String idValue);

    List<T> getAllDocuments();
}