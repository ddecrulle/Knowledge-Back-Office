package fr.insee.knowledge.domain;

import java.util.List;

public class Function extends GenericIDLabel {
    private Boolean dispo;
    private GenericIDLabel gsbpm;
    private String idProduct;
    private List<GenericIDLabel> users;
    private List<GenericIDLabel> products;
    private List<Task> tasks;
    private Service service;

    public Function(String id, String label, String description, Boolean dispo, Gsbpm gsbpm, String idProduct, List<GenericIDLabel> users, List<Gsbpm> tools, List<Task> tasks, Service service) {
        super(id, label, description);
        this.dispo = dispo;
        this.gsbpm = gsbpm;
        this.idProduct = idProduct;
        this.users = users;
        this.tasks = tasks;
        this.service = service;
    }

    public Function() {
        super();
    }

    public Boolean getDispo() {
        return dispo;
    }

    public void setDispo(Boolean dispo) {
        this.dispo = dispo;
    }

    public GenericIDLabel getGsbpm() {
        return gsbpm;
    }

    public void setGsbpm(GenericIDLabel gsbpm) {
        this.gsbpm = gsbpm;
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

    public List<GenericIDLabel> getProducts() {
        return products;
    }

    public void setProducts(List<GenericIDLabel> products) {
        this.products = products;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}