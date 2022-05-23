package fr.insee.knowledge.domain;

public class Service extends GenericIDLabel {

    private Service service;
    private String description;

    public Service(Service service, String description, String id, String label) {
        super(id, label);
        this.service = service;
        this.description = description;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
