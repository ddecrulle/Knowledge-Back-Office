package fr.insee.knowledge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public class Products {

    @JsonProperty("id")
    private String id;
    @JsonProperty("nodeKey")
    private String nodeKey;
    @JsonProperty("label")
    private String label;
    @JsonDeserialize(contentAs= Products.class)
    private List<Products> outils;

    public Products() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNodeKey() {
        return nodeKey;
    }

    public void setNodeKey(String nodeKey) {
        this.nodeKey = nodeKey;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Products> getOutils() {
        return outils;
    }

    public void setOutils(List<Products> outils) {
        this.outils = outils;
    }
}
