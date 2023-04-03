package fr.insee.knowledge.domain;

public class Service extends GenericIDLabel {

    private Service service;

    public Service(Service service, String description, String id, String label) {
        super(id, label, description);
        this.service = service;
    }

    public Service() {
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
