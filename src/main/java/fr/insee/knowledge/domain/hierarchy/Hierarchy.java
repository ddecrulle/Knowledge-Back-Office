package fr.insee.knowledge.domain.hierarchy;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.insee.knowledge.domain.GenericIDLabel;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Hierarchy<T extends Hierarchy> extends GenericIDLabel {
    private List<T> children;

    public Hierarchy() {
        super();
    }

    public Hierarchy(String id, String label) {
        super(id, label);
    }

    public Hierarchy(String id, String label, String description) {
        super(id, label, description);
    }

    public Hierarchy(String id, String label, List<T> children) {
        super(id, label);
        this.children = children;
    }

    public Hierarchy(String id, String label, String description, List<T> children) {
        super(id, label, description);
        this.children = children;
    }

    @Override
    public String toString() {
        return "Hierarchy{" +
                "children=" + children +
                ", description='" + this.getDescription() + '\'' +
                "} " + super.toString();
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    public Hierarchy<T> getChildrenById(String targetId) {
        if (hasId(targetId)) {
            return this;
        }
        if (this.children != null) {
            for (T child : this.children) {
                Hierarchy<T> found = child.getChildrenById(targetId);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }
}
