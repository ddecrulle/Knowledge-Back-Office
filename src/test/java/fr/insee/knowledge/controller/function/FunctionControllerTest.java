package fr.insee.knowledge.controller.function;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.domain.Function;
import fr.insee.knowledge.utils.Utils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionControllerTest {

    @Test
    public void getNonExistingFieldFromJsonNode() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree("{\"id\":1}");
        JsonNode nullJsonNode = jsonNode.get("foo");
        assertNull(nullJsonNode);
    }

//    @Test
//    public void testRecursiveMapping() throws IOException {
//        // given
//        String jsonContent = Utils.readFileFromUrl(
//                FunctionControllerTest.class.getClassLoader().getResource("sample.json"));
//        // when
//        List<Function> res = FunctionController.listFunctionsFromJson(jsonContent);
//
//        // then
//        assertNotNull(res);
//        //
//        assertFalse(res.isEmpty());
//        //
//        Function testedFunction = res.stream()
//                .filter(function -> function.getLabel().equals("Spécifier un modèle de questionnaire"))
//                .findAny().orElse(null);
//        assertNotNull(testedFunction);
//        assertEquals("S121", testedFunction.getServiceBpmn().getId());
//        assertEquals("S120", testedFunction.getServiceBpmn().getServiceBpmn().getId());
//        assertEquals("S100", testedFunction.getServiceBpmn().getServiceBpmn().getServiceBpmn().getId());
//    }
}
