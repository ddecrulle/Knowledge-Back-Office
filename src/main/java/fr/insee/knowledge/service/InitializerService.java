package fr.insee.knowledge.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface InitializerService {

    void createCollections();

    void importDataFromGithub() throws IOException;
}
