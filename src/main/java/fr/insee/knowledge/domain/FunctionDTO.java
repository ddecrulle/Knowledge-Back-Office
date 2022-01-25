package fr.insee.knowledge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public class FunctionDTO {

    @JsonProperty("label")
    public String label;
    @JsonProperty("utilisateurs")
    public String users;
    @JsonProperty("dispo")
    public int available;
    @JsonProperty("description")
    public String description;
    @JsonProperty("gsbpm")
    public String gsbpm;
    @JsonDeserialize(contentAs = Task.class)
    public List<Task> taches;
    @JsonProperty("produit")
    public String products;
    @JsonProperty("macroservice")
    public String macroservice;
    @JsonProperty("service")
    public String service;
    @JsonProperty("sousservice")
    public String sousservice;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGsbpm() {
        return gsbpm;
    }

    public void setGsbpm(String gsbpm) {
        this.gsbpm = gsbpm;
    }

    public List<Task> getTaches() {
        return taches;
    }

    public void setTaches(List<Task> taches) {
        this.taches = taches;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }
}
