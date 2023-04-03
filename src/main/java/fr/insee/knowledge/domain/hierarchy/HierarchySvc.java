package fr.insee.knowledge.domain.hierarchy;

import java.util.List;

public class HierarchySvc extends Hierarchy<HierarchySvc> {

    public HierarchySvc() {
    }

    public HierarchySvc(String id, String label) {
        super(id, label);
    }

    public HierarchySvc(String id, String label, String description) {
        super(id, label, description);
    }

    public HierarchySvc(String id, String label, List<HierarchySvc> children) {
        super(id, label, children);
    }

    public HierarchySvc(String id, String label, String description, List<HierarchySvc> children) {
        super(id, label, description, children);
    }
}
