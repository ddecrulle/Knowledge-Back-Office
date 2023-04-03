package fr.insee.knowledge.domain.hierarchy;

import java.util.List;

public class HierarchyUser extends Hierarchy<HierarchyUser> {

    public HierarchyUser() {
    }

    public HierarchyUser(String id, String label) {
        super(id, label);
    }

    public HierarchyUser(String id, String label, String description) {
        super(id, label, description);
    }

    public HierarchyUser(String id, String label, List<HierarchyUser> children) {
        super(id, label, children);
    }

    public HierarchyUser(String id, String label, String description, List<HierarchyUser> children) {
        super(id, label, description, children);
    }
}
