package fr.insee.knowledge.domain;

import java.util.List;

public class Product {

    private String name;
    private String description;
    private String mode;
    private String usage;
    private List<Product> relatedProducts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public List<Product> getRelatedProducts() {
        return relatedProducts;
    }

    public void setRelatedProducts(List<Product> relatedProducts) {
        this.relatedProducts = relatedProducts;
    }
}
