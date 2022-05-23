package fr.insee.knowledge.domain;

public class Task extends GenericIDLabel {

    private String description;
    private String labelStatus;

    public Task(String description,String labelStatus,String id,String label) {
        super(id,label);
        this.description = description;
        this.labelStatus = labelStatus;

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
