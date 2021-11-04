package fr.insee.knowledge.controller;

import fr.insee.knowledge.domain.File;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class KnowledgeResourcesAPI {

    private final static Logger LOGGER = LoggerFactory.getLogger(KnowledgeResourcesAPI.class);

    /**
     * This method is using to get all files from git repo
     *
     * @return List of all {@link File}
     */
    @ApiOperation(value = "Get list of files")
    @GetMapping(path = "/files")
    public ResponseEntity<Object> getFiles(){
      /*  Git git = Git.cloneRepository()
                .setURI("https://github.com/eclipse/jgit.git")
                .setDirectory("/path/to/repo")
                .call();
    */
        List<File> resp = new ArrayList<File>();
        File file = new File();
        file.setFileName("test file name");
        file.setFolder(false);
        file.setPath("test path");
        resp.add(file);
        LOGGER.info("GET files resulting in 200");
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

}


