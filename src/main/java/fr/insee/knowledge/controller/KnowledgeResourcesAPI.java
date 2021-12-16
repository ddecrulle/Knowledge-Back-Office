package fr.insee.knowledge.controller;

import fr.insee.knowledge.domain.KnowledgeFile;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.eclipse.jgit.api.Git;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/api")
public class KnowledgeResourcesAPI {

    private final static Logger LOGGER = LoggerFactory.getLogger(KnowledgeResourcesAPI.class);

    /**
     * This method is using to get all files from git repo
     *
     * @return List of all {@link KnowledgeFile}
     */
    @ApiOperation(value = "Get list of files")
    @GetMapping(path = "/files")
    public ResponseEntity<Object> getFiles() throws IOException, GitAPIException {
        List<KnowledgeFile> resp = new ArrayList<KnowledgeFile>();
        File localPath = File.createTempFile("GitRepositoryKnowledge", "");
        Files.delete(localPath.toPath());

        Git git = Git.cloneRepository()
                .setURI("https://github.com/bwerquin/Knowledge-Data.git")
                .setDirectory(localPath)
                .call();
        NotFileFilter suffixFileFilterFileFilter=new NotFileFilter(new SuffixFileFilter(new String[] { "txt", "java" }));
        Collection<File> files = FileUtils.listFiles(localPath, suffixFileFilterFileFilter, TrueFileFilter.INSTANCE);
        for(File file2 : files){
            KnowledgeFile file = new KnowledgeFile();
            file.setFileName(file2.getName());
            file.setFolder(file2.isDirectory());
            file.setPath(file2.getPath());
            resp.add(file);
        }

        LOGGER.info("GET files resulting in 200");
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

}


