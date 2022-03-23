package fr.insee.knowledge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.domain.*;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;

@RestController
@RequestMapping(path = "/github")
public class KnowledgeImportGithub {

    @Value("${fr.insee.knowledge.git.access.rawrepository}")
    private String githubRepository;

    private final static Logger LOGGER = LoggerFactory.getLogger(KnowledgeImportGithub.class);

    @Operation(summary = "Import Functions")
    @GetMapping(path = "/functions")
    public ResponseEntity<Function[]> getFunctionsFromGithub() throws IOException {
        String fileName = "fonctions.json";
        URL url = new URL(githubRepository + fileName);
        ObjectMapper mapper = new ObjectMapper();

        Function[] functions = mapper.readValue(url, Function[].class);
        return new ResponseEntity<Function[]>(functions, HttpStatus.OK);
    }

    @Operation(summary = "Import Tools")
    @GetMapping(path = "/tools")
    public ResponseEntity<Tool[]> getToolsFromGithub() throws IOException {
        String fileName = "outils.json";
        URL url = new URL(githubRepository + fileName);
        ObjectMapper mapper = new ObjectMapper();

        Tool[] tools = mapper.readValue(url, Tool[].class);
        return new ResponseEntity<Tool[]>(tools, HttpStatus.OK);
    }

    @Operation(summary = "Import GSBPM Phases")
    @GetMapping(path = "/gsbpm")
    public ResponseEntity<Gsbpm[]> getGsbpmFromGithub() throws IOException {
        String fileName = "gsbpm.json";
        URL url = new URL(githubRepository + fileName);
        ObjectMapper mapper = new ObjectMapper();

        Gsbpm[] gsbpms = mapper.readValue(url, Gsbpm[].class);
        return new ResponseEntity<Gsbpm[]>(gsbpms, HttpStatus.OK);
    }

    @Operation(summary = "Import Products")
    @GetMapping(path = "/products")
    public ResponseEntity<Products[]> getProductsFromGithub() throws IOException {
        String fileName = "produits.json";
        URL url = new URL(githubRepository + fileName);
        ObjectMapper mapper = new ObjectMapper();

        Products[] products = mapper.readValue(url, Products[].class);
        return new ResponseEntity<Products[]>(products, HttpStatus.OK);
    }

    @Operation(summary = "Import services")
    @GetMapping(path = "/services")
    public ResponseEntity<Service[]> getServicesFromGithub() throws IOException {
        String fileName = "services.json";
        URL url = new URL(githubRepository + fileName);
        ObjectMapper mapper = new ObjectMapper();

        Service[] services = mapper.readValue(url, Service[].class);
        return new ResponseEntity<Service[]>(services, HttpStatus.OK);
    }

    //TODO End Point for statuts

    @Operation(summary = "Import users")
    @GetMapping(path = "/users")
    public ResponseEntity<Users[]> getUsersFromGithub() throws IOException {
        String fileName = "utilisateurs.json";
        URL url = new URL(githubRepository + fileName);
        ObjectMapper mapper = new ObjectMapper();

        Users[] users = mapper.readValue(url, Users[].class);
        return new ResponseEntity<Users[]>(users, HttpStatus.OK);
    }
}
