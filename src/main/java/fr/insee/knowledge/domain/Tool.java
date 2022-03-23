package fr.insee.knowledge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tool {
    @JsonProperty("id")
    public String id;
    @JsonProperty("label")
    public String label;
    @JsonProperty("description")
    public String description;
    @JsonProperty("mode")
    public String mode;
    @JsonProperty("utilisation")
    public String utilisation;
    @JsonProperty("produitId")
    public String produitId;
    @JsonProperty("produitLabel")
    public String produitLabel;

    public Tool() {
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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getUtilisation() {
        return utilisation;
    }

    public void setUtilisation(String utilisation) {
        this.utilisation = utilisation;
    }

    public String getProduitId() {
        return produitId;
    }

    public void setProduitId(String produitId) {
        this.produitId = produitId;
    }

    public String getProduitLabel() {
        return produitLabel;
    }

    public void setProduitLabel(String produitLabel) {
        this.produitLabel = produitLabel;
    }
}
