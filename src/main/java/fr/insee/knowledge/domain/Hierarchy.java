package fr.insee.knowledge.domain;

import java.util.List;

public class Hierarchy extends GenericIDLabel {
    private List<Hierarchy> children;
    private String description;

    public Hierarchy() {
        super();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Hierarchy(String id, String label) {
        super(id, label);
    }

    public Hierarchy(String id, String label, String description) {
        super(id, label);
        this.description = description;
    }

    public Hierarchy(String id, String label, List<Hierarchy> children) {
        super(id, label);
        this.children = children;
    }

    public Hierarchy(String id, String label, String description, List<Hierarchy> children) {
        super(id, label);
        this.children = children;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Hierarchy{" +
                "children=" + children +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }

    public List<Hierarchy> getChildren() {
        return children;
    }

    public void setChildren(List<Hierarchy> children) {
        this.children = children;
    }
}
