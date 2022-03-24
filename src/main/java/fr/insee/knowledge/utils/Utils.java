package fr.insee.knowledge.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Utils {

    public static String readFileFromResources(String fileName) throws IOException {
        return IOUtils.resourceToString(fileName, StandardCharsets.UTF_8);
    }

}
