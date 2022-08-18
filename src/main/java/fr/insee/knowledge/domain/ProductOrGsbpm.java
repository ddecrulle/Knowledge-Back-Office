package fr.insee.knowledge.domain;

public class ProductOrGsbpm extends GenericIDLabel {
    private String description;

    public ProductOrGsbpm() {
    }

    public ProductOrGsbpm(String id, String label) {
        super(id, label);
    }

    public ProductOrGsbpm(String id, String label, String description) {
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
