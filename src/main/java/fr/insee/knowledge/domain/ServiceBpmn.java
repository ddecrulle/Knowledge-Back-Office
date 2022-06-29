package fr.insee.knowledge.domain;

public class ServiceBpmn extends GenericIDLabel {

    private ServiceBpmn serviceBpmn;
    private String description;

    public ServiceBpmn(ServiceBpmn serviceBpmn, String description, String id, String label) {
        super(id, label);
        this.serviceBpmn = serviceBpmn;
        this.description = description;
    }

    public ServiceBpmn() {}

    public ServiceBpmn getServiceBpmn() {
        return serviceBpmn;
    }

    public void setServiceBpmn(ServiceBpmn serviceBpmn) {
        this.serviceBpmn = serviceBpmn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
