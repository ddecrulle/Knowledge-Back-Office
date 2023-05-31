package fr.insee.knowledge.domain;

import java.util.List;

public class RawFunction extends GenericIDLabel {
    private Boolean dispo;
    private String gsbpm;
    private String idProduct;
    private List<String> users;
    private List<String> products;
    private List<Task> tasks;
    private Service service;

    public RawFunction(String id, String label, String description, Boolean dispo, String gsbpm, String idProduct, List<String> users, List<String> products, List<Task> tasks, Service service) {
        super(id, label, description);
        this.dispo = dispo;
        this.gsbpm = gsbpm;
        this.idProduct = idProduct;
        this.users = users;
        this.products = products;
        this.tasks = tasks;
        this.service = service;
    }

    public RawFunction() {
    }

    public Boolean getDispo() {
        return dispo;
    }

    public void setDispo(Boolean dispo) {
        this.dispo = dispo;
    }

    public String getGsbpm() {
        return gsbpm;
    }

    public void setGsbpm(String gsbpm) {
        this.gsbpm = gsbpm;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
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
