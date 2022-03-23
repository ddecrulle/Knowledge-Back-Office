package fr.insee.knowledge.controller;

import fr.insee.knowledge.git.access.GsbpmDataAccess;
import fr.insee.knowledge.git.access.ProductDataAccess;
import fr.insee.knowledge.git.access.ServiceDataAccess;
import fr.insee.knowledge.domain.Gsbpm;
import fr.insee.knowledge.domain.KnowledgeFile;
import fr.insee.knowledge.domain.Products;
import fr.insee.knowledge.domain.Service;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(path = "/git")
public class KnowledgeResourcesAPI {

    private final static Logger LOGGER = LoggerFactory.getLogger(KnowledgeResourcesAPI.class);

    @Autowired
    ServiceDataAccess serviceDataAccess;

    @Autowired
    GsbpmDataAccess gsbpmDataAccess;

    @Autowired
    ProductDataAccess productDataAccess;

    /**
     * This method is using to get all files from git repo with JSON extensions
     *
     * @return List of all {@link KnowledgeFile}
     */
    @Operation(summary = "Get list of files")
    @GetMapping(path = "/files")
    public ResponseEntity<Object> getFiles() throws IOException, GitAPIException {
        List<KnowledgeFile> resp = new ArrayList<KnowledgeFile>();
        File localPath = File.createTempFile("GitRepositoryKnowledge", "");
        Files.delete(localPath.toPath());

        Git git = Git.cloneRepository()
                .setURI("https://github.com/bwerquin/Knowledge-Data.git")
                .setDirectory(localPath)
                .call();
        NotFileFilter suffixFileFilterFileFilter=new NotFileFilter(new SuffixFileFilter(new String[] { "md", "MD", ".git",".pack","idx" }));
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

    /**
     * This method is using to get services JSON representation from git repo
     *
     * @return List of all {@link fr.insee.knowledge.domain.Service}
     */
    @Operation(summary="Get services from git repo")
    @GetMapping(path = "/services")
    public ResponseEntity<Object> getServices() throws IOException, GitAPIException {
        List<Service> services = null;
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
            if(file2.getName().toUpperCase(Locale.ROOT).equalsIgnoreCase("services.json")){
                services = serviceDataAccess.serializeFromFile(file);
                LOGGER.info("services.json serialized");
            }
        }
        LOGGER.info("GET services resulting in 200");
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    /**
     * This method is using to get GSBPM JSON representation from git repo
     *
     * @return List of all {@link fr.insee.knowledge.domain.Gsbpm}
     */
    @Operation(summary = "Get GSBPM Phases from git repo")
    @GetMapping(path = "/gsbpm")
    public ResponseEntity<Object> getGSBPM() throws IOException, GitAPIException {
        List<Gsbpm> gsbpms = null;
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
            if(file2.getName().toUpperCase(Locale.ROOT).equalsIgnoreCase("gsbpm.json")){
                gsbpms = gsbpmDataAccess.serializeFromFile(file);
                LOGGER.info("gsbpm.json serialized");
            }
        }
        LOGGER.info("GET gsbpm resulting in 200");
        return new ResponseEntity<>(gsbpms, HttpStatus.OK);
    }

    /**
     * This method is using to get produit JSON representation from git repo
     *
     * @return List of all {@link Products}
     */
    @Operation(summary ="Get Product from git repo" )
    @GetMapping(path = "/products")
    public ResponseEntity<Object> getProducts() throws IOException, GitAPIException {
        List<Products> products = null;
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
            if(file2.getName().toUpperCase(Locale.ROOT).equalsIgnoreCase("produits.json")){
                products = productDataAccess.serializeFromFile(file);
                LOGGER.info("produits.json serialized");
            }
        }
        LOGGER.info("GET produit resulting in 200");
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}


