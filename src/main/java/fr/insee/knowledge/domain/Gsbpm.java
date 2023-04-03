package fr.insee.knowledge.domain;

public class Gsbpm extends GenericIDLabel {
    private String description;

    public Gsbpm() {
    }

    public Gsbpm(String id, String label) {
        super(id, label);
    }

    public Gsbpm(String id, String label, String description) {
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
