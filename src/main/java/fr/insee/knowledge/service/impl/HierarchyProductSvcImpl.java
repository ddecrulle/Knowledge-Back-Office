package fr.insee.knowledge.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.knowledge.dao.HierarchyProductDAO;
import fr.insee.knowledge.domain.hierarchy.HierarchyProduct;
import fr.insee.knowledge.service.HierarchyProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

import static fr.insee.knowledge.constants.Constants.*;

@Service
public class HierarchyProductSvcImpl implements HierarchyProductSvc {
    @Autowired
    private HierarchyProductDAO hierarchyProductDAO;
    private final ObjectMapper mapper = new ObjectMapper();

    @Value("${fr.insee.knowledge.git.access.rawrepository}")
    private String githubRepository;

    public HierarchyProduct getProducts() {
        return hierarchyProductDAO.findById(idProductsDocument);
    }

    @Override
    public String importProduct() throws IOException {
        HierarchyProduct hierarchyProduct = mapper.readValue(new URL(githubRepository + GithubProductsFile), HierarchyProduct.class);
        return hierarchyProductDAO.insertOrReplaceOne(hierarchyProduct);
    }

    //TODO
    @Override
    public Boolean isProductExist(String id) {
        return true;
    }
}
