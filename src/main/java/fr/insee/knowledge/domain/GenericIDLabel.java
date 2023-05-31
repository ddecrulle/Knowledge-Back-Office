package fr.insee.knowledge.domain;

public class GenericIDLabel {
    private String id;
    private String label;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GenericIDLabel(String id, String label, String description) {
        this.id = id;
        this.label = label;
        this.description = description;
    }

    public GenericIDLabel() {
    }

    public GenericIDLabel(String id, String label) {
        this.id = id;
        this.label = label;
    }

    @Override
    public String toString() {
        return "GenericIDLabel{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                '}';
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

    public boolean hasId(String targetId) {
        return id.equals(targetId);
    }
}
