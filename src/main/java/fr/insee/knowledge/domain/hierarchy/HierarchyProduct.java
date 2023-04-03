package fr.insee.knowledge.domain.hierarchy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class HierarchyProduct extends Hierarchy<HierarchyProduct> {

    private String iconUrl;
    private String color;

    public HierarchyProduct() {
    }

    public HierarchyProduct(String id, String label, String description) {
        super(id, label, description);
    }

    public HierarchyProduct(String id, String label, String description, String iconUrl, String color) {
        super(id, label, description);
        this.iconUrl = iconUrl;
        this.color = color;
    }

    public HierarchyProduct(String id, String label, String description, List<HierarchyProduct> children, String iconUrl, String color) {
        super(id, label, description, children);
        this.iconUrl = iconUrl;
        this.color = color;
    }

    public HierarchyProduct(String id, String label, String description, List<HierarchyProduct> children) {
        super(id, label, description, children);
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
