package fr.insee.knowledge.domain;

public class Function extends GenericIDLabel {


    private String name;
    private String description;
    private int dispo;
    private GenericIDLabel gsbpm;
    private GenericIDLabel product;
    private GenericIDLabel[] users;
    private GenericIDLabel[] tools;
    private Task[] tasks;

    private ServiceBpmn serviceBpmn;

    public Function(String id, String label,String name, String description, int dispo, GenericIDLabel gsbpm, GenericIDLabel product, GenericIDLabel[] users, GenericIDLabel[] tools, Task[] tasks, ServiceBpmn serviceBpmn) {
        super(id,label);
        this.name = name;
        this.description = description;
        this.dispo = dispo;
        this.gsbpm = gsbpm;
        this.product = product;
        this.users = users;
        this.tools = tools;
        this.tasks = tasks;
        this.serviceBpmn = serviceBpmn;
    }

    public Function() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public GenericIDLabel getGsbpm() {
        return gsbpm;
    }

    public void setGsbpm(GenericIDLabel gsbpm) {
        this.gsbpm = gsbpm;
    }

    public GenericIDLabel getProduct() {
        return product;
    }

    public void setProduct(GenericIDLabel product) {
        this.product = product;
    }

    public GenericIDLabel[] getUsers() {
        return users;
    }

    public void setUsers(GenericIDLabel[] users) {
        this.users = users;
    }

    public GenericIDLabel[] getTools() {
        return tools;
    }

    public void setTools(GenericIDLabel[] tools) {
        this.tools = tools;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public ServiceBpmn getServiceBpmn() {
        return serviceBpmn;
    }

    public void setServiceBpmn(ServiceBpmn serviceBpmn) {
        this.serviceBpmn = serviceBpmn;
    }
}