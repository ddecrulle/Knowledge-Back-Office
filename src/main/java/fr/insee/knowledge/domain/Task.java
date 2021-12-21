package fr.insee.knowledge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {

    @JsonProperty("label")
    public String label;
    @JsonProperty("description")
    public String description;
    @JsonProperty("statut")
    public String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
