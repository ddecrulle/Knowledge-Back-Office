package fr.insee.knowledge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    @JsonProperty("nom")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("utilisation")
    private String usage;
    @JsonProperty("produits")
    private String relatedProducts;

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

    public String getRelatedProducts() {
        return relatedProducts;
    }

    public void setRelatedProducts(String relatedProducts) {
        this.relatedProducts = relatedProducts;
    }
}
