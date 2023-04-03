package fr.insee.knowledge.domain.hierarchy;

import java.util.List;

public class HierarchyService extends Hierarchy<HierarchyService> {

    public HierarchyService() {
    }

    public HierarchyService(String id, String label) {
        super(id, label);
    }

    public HierarchyService(String id, String label, String description) {
        super(id, label, description);
    }

    public HierarchyService(String id, String label, List<HierarchyService> children) {
        super(id, label, children);
    }

    public HierarchyService(String id, String label, String description, List<HierarchyService> children) {
        super(id, label, description, children);
    }
}
