package fr.insee.knowledge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public class Gsbpm {

    @JsonProperty("id")
    private String id;
    @JsonProperty("label")
    private String label;
    @JsonProperty("description")
    private String description;
    @JsonDeserialize(contentAs=Gsbpm.class)
    private List<Gsbpm> processus;

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

    public List<Gsbpm> getProcessus() {
        return processus;
    }

    public void setProcessus(List<Gsbpm> processus) {
        this.processus = processus;
    }
}
