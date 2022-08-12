package fr.insee.knowledge.domain;

public class Tools extends GenericIDLabel {
    private String description;

    public Tools() {
    }

    public Tools(String id, String label) {
        super(id, label);
    }

    public Tools(String id, String label, String description) {
        super(id, label);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
