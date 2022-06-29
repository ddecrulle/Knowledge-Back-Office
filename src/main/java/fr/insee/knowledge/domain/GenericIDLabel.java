package fr.insee.knowledge.domain;

public class GenericIDLabel {
    private String id;
    private String label;

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
}
