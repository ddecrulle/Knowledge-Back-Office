package fr.insee.knowledge.git.access;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.domain.KnowledgeFile;
import fr.insee.knowledge.domain.Products;

import java.io.File;
import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Service
public class ProductDataAccess {

    public List<Products> serializeFromFile(KnowledgeFile resource) throws IOException {

       ObjectMapper objectMapper = new ObjectMapper();
       List<Products> products;
       products = objectMapper.readValue(new File(resource.getPath()), new TypeReference<List<Products>>() {});
       return products;

    }

}
