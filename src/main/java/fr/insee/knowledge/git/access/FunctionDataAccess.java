package fr.insee.knowledge.git.access;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.domain.FunctionDTO;
import fr.insee.knowledge.domain.KnowledgeFile;
import fr.insee.knowledge.domain.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Service
public class FunctionDataAccess {

    public List<FunctionDTO> serializeFromFile(KnowledgeFile resource) throws IOException {

       ObjectMapper objectMapper = new ObjectMapper();
       List<FunctionDTO> functions;
       functions = objectMapper.readValue(new File(resource.getPath()), new TypeReference<List<FunctionDTO>>() {});
       return functions;

    }

}
