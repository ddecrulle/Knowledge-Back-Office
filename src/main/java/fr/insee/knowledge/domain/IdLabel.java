package fr.insee.knowledge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IdLabel {
    @JsonProperty("id")
    public String id;
    @JsonProperty("label")
    public String label;

    public IdLabel() {
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
}
