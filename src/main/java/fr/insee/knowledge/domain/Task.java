package fr.insee.knowledge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {

    @JsonProperty("id")
    public String id;
    @JsonProperty("label")
    public String label;
    @JsonProperty("description")
    public String description;
    @JsonProperty("statutId")
    public String statutId;
    @JsonProperty("statutLabel")
    public String statutLabel;

    public Task() {
    }

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

    public String getStatutId() {
        return statutId;
    }

    public void setStatutId(String statutId) {
        this.statutId = statutId;
    }

    public String getStatutLabel() {
        return statutLabel;
    }

    public void setStatutLabel(String statutLabel) {
        this.statutLabel = statutLabel;
    }
}
