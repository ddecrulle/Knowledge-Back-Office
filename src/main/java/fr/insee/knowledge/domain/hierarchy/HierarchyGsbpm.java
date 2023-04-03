package fr.insee.knowledge.domain.hierarchy;

import java.util.List;

public class HierarchyGsbpm extends Hierarchy<HierarchyGsbpm> {
    public HierarchyGsbpm() {
    }

    public HierarchyGsbpm(String id, String label) {
        super(id, label);
    }

    public HierarchyGsbpm(String id, String label, String description) {
        super(id, label, description);
    }

    public HierarchyGsbpm(String id, String label, List<HierarchyGsbpm> children) {
        super(id, label, children);
    }

    public HierarchyGsbpm(String id, String label, String description, List<HierarchyGsbpm> children) {
        super(id, label, description, children);
    }
}
