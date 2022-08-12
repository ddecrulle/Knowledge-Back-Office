package fr.insee.knowledge.domain;

import java.util.List;

public class Function extends GenericIDLabel {
    private String description;
    private int dispo;
    private String idGsbpm;
    private String idProduct;
    private List<GenericIDLabel> users;
    private List<Tools> tools;
    private List<Task> tasks;

    private ServiceBpmn serviceBpmn;

    public Function(String id, String label, String description, int dispo, String idGsbpm, String idProduct, List<GenericIDLabel> users, List<Tools> tools, List<Task> tasks, ServiceBpmn serviceBpmn) {
        super(id, label);
        this.description = description;
        this.dispo = dispo;
        this.idGsbpm = idGsbpm;
        this.idProduct = idProduct;
        this.users = users;
        this.tools = tools;
        this.tasks = tasks;
        this.serviceBpmn = serviceBpmn;
    }

    public Function() {
        super();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDispo() {
        return dispo;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    public String getIdGsbpm() {
        return idGsbpm;
    }

    public void setIdGsbpm(String idGsbpm) {
        this.idGsbpm = idGsbpm;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public List<GenericIDLabel> getUsers() {
        return users;
    }

    public void setUsers(List<GenericIDLabel> users) {
        this.users = users;
    }

    public List<Tools> getTools() {
        return tools;
    }

    public void setTools(List<Tools> tools) {
        this.tools = tools;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public ServiceBpmn getServiceBpmn() {
        return serviceBpmn;
    }

    public void setServiceBpmn(ServiceBpmn serviceBpmn) {
        this.serviceBpmn = serviceBpmn;
    }
}