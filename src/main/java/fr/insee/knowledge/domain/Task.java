package fr.insee.knowledge.domain;

public class Task {

    private String description;
    private String labelStatus;
    private String label;

    public Task() {
    }

    public Task(String description, String labelStatus, String label) {
        this.label = label;
        this.description = description;
        this.labelStatus = labelStatus;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelStatus() {
        return labelStatus;
    }

    public void setLabelStatus(String labelStatus) {
        this.labelStatus = labelStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
