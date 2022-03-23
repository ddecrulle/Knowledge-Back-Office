package fr.insee.knowledge.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ImportFileFromGithub {

    private final static Logger LOGGER = LoggerFactory.getLogger(ImportFileFromGithub.class);

    public static <T> TypeReference<List<T>> list() {
        return new TypeReference<List<T>>() {
        };
    }

    public List<Object> getJsonFromGithub(URL url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(url, list());
    }
}
