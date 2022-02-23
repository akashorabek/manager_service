package kz.attractor.datamodel.model;

import java.util.HashMap;
import java.util.Map;

public enum ContactStatus {
    CONTACT_CONSTANT("Постоянный"),
    CONTACT_NEW("Новый"),
    CONTACT_ARCHIVE("Архивный");

    public final String label;
    private static final Map<String, ContactStatus> BY_LABEL = new HashMap<>();

    static {
        for(ContactStatus status: values()) {
            BY_LABEL.put(status.label, status);
        }
    }
    private ContactStatus(String label) {
        this.label = label;
    }

    public static ContactStatus valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
