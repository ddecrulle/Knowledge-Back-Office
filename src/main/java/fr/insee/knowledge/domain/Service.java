package fr.insee.knowledge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public class Service {

    @JsonProperty("id")
    public String id;
    @JsonProperty("label")
    public String label;
    @JsonProperty("description")
    public String description;
    @JsonProperty("niveau")
    public int level;
    @JsonProperty("gsbpm")
    public String gsbpm;
    @JsonDeserialize(contentAs=Service.class)
    public List<Service> service;
    @JsonDeserialize(contentAs=Function.class)
    public List<Function> fonction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getGsbpm() {
        return gsbpm;
    }

    public void setGsbpm(String gsbpm) {
        this.gsbpm = gsbpm;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    public List<Function> getFonction() {
        return fonction;
    }

    public void setFonction(List<Function> fonction) {
        this.fonction = fonction;
    }
}
