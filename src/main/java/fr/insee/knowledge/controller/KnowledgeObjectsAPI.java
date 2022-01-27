package fr.insee.knowledge.controller;

import fr.insee.knowledge.domain.*;
import fr.insee.knowledge.git.access.FunctionDataAccess;
import fr.insee.knowledge.git.access.GsbpmDataAccess;
import fr.insee.knowledge.git.access.ProductDataAccess;
import fr.insee.knowledge.git.access.ServiceDataAccess;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(path = "/model")
public class KnowledgeObjectsAPI {

    private final static Logger LOGGER = LoggerFactory.getLogger(KnowledgeObjectsAPI.class);


    @Autowired
    FunctionDataAccess functionDataAccess;

    /**
     * This method is using to get function JSON representation from MongoDB
     *
     * @return List of all {@link Service}
     */
    @ApiOperation(value = "Get functions from mongodb")
    @GetMapping(path = "/functions")
    public ResponseEntity<Object> getFunctions() throws IOException, GitAPIException {
        List<FunctionDTO> functions = null;
        File localPath = File.createTempFile("GitRepositoryKnowledge", "");
        Files.delete(localPath.toPath());

        Git git = Git.cloneRepository()
                .setURI("https://github.com/bwerquin/Knowledge-Data.git")
                .setDirectory(localPath)
                .call();
        NotFileFilter suffixFileFilterFileFilter=new NotFileFilter(new SuffixFileFilter(new String[] { "md", "MD", ".git",".pack","idx"}));
        Collection<File> files = FileUtils.listFiles(localPath, suffixFileFilterFileFilter, TrueFileFilter.INSTANCE);
        for(File file2 : files){
            KnowledgeFile file = new KnowledgeFile();
            file.setFileName(file2.getName());
            file.setFolder(file2.isDirectory());
            file.setPath(file2.getPath());
            if(file2.getName().toUpperCase(Locale.ROOT).equalsIgnoreCase("fonctions.json")){
                functions = functionDataAccess.serializeFromFile(file);
                LOGGER.info("fonctions.json serialized");
            }
        }
        LOGGER.info("GET services resulting in 200");
        return new ResponseEntity<>(functions, HttpStatus.OK);
    }



}


