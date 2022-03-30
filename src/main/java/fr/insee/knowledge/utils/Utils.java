package fr.insee.knowledge.utils;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Utils {

    private final static Logger LOGGER = LoggerFactory.getLogger(Utils.class);

    public static String readFileFromResources(String fileName) throws IOException {
        return IOUtils.resourceToString(fileName, StandardCharsets.UTF_8);
    }

    public static String readFileFromUrl(URL url) throws IOException {
        try {
            LOGGER.info("IOUtils.toString");
            return IOUtils.toString(url, StandardCharsets.UTF_8);
        } catch (Exception e) {
            LOGGER.error("An error occured when try to fetch data on url : {}", url);
            throw e;
        }
    }

}
