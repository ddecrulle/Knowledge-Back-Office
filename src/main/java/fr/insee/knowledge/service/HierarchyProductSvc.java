package fr.insee.knowledge.service;

import fr.insee.knowledge.domain.hierarchy.*;

import java.io.IOException;

public interface HierarchyProductSvc {

    HierarchyProduct getProducts();

    String importProduct() throws IOException;

    Boolean isProductExist(String id);
}
