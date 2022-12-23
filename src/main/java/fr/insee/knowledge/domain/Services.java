package fr.insee.knowledge.domain;

public class Services extends GenericIDLabel {

    private Services services;
    private String description;

    public Services(Services services, String description, String id, String label) {
        super(id, label);
        this.services = services;
        this.description = description;
    }

    public Services() {
    }

    public Services getService() {
        return services;
    }

    public void setService(Services services) {
        this.services = services;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
