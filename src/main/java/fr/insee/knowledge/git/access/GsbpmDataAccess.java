package fr.insee.knowledge.git.access;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.domain.Gsbpm;
import fr.insee.knowledge.domain.KnowledgeFile;


import java.io.File;
import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Service
public class GsbpmDataAccess {

    public List<Gsbpm> serializeFromFile(KnowledgeFile resource) throws IOException {

       ObjectMapper objectMapper = new ObjectMapper();
       List<Gsbpm> gsbpms;
       gsbpms = objectMapper.readValue(new File(resource.getPath()), new TypeReference<List<Gsbpm>>() {});
       return gsbpms;

    }

}
