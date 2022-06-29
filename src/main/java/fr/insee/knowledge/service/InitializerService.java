package fr.insee.knowledge.service;

import java.io.IOException;

public interface InitializerService {

    void createCollections();

    void importDataFromGithub() throws IOException;
}
