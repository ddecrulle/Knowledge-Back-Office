package fr.insee.knowledge.data.access;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.domain.KnowledgeFile;
import fr.insee.knowledge.domain.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceDataAccess {

    public List<Service> serializeFromFile(KnowledgeFile resource) throws IOException {

       ObjectMapper objectMapper = new ObjectMapper();
       List<Service> services;
       services = objectMapper.readValue(new File(resource.getPath()), new TypeReference<List<Service>>() {});
       return services;

    }

}
