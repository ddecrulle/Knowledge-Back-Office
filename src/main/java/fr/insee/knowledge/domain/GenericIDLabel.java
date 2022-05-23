package fr.insee.knowledge.domain;

public class GenericIDLabel
{
    private String id;
    private String label;

    public GenericIDLabel(String id, String label)
    {
        this.id = id;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
