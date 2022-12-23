package fr.insee.knowledge.domain;

import java.util.List;

public class Function extends GenericIDLabel {
    private String description;
    private int dispo;
    private ProductOrGsbpm gsbpm;
    private String idProduct;
    private List<GenericIDLabel> users;
    private List<ProductOrGsbpm> products;
    private List<Task> tasks;

    private Service serviceBpmn;

    public Function(String id, String label, String description, int dispo, ProductOrGsbpm gsbpm, String idProduct, List<GenericIDLabel> users, List<ProductOrGsbpm> tools, List<Task> tasks, Service serviceBpmn) {
        super(id, label);
        this.description = description;
        this.dispo = dispo;
        this.gsbpm = gsbpm;
        this.idProduct = idProduct;
        this.users = users;
        this.products = products;
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

    public ProductOrGsbpm getGsbpm() {
        return gsbpm;
    }

    public void setGsbpm(ProductOrGsbpm gsbpm) {
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

    public List<ProductOrGsbpm> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOrGsbpm> products) {
        this.products = products;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Service getServiceBpmn() {
        return serviceBpmn;
    }

    public void setServiceBpmn(Service service) {
        this.serviceBpmn = service;
    }
}