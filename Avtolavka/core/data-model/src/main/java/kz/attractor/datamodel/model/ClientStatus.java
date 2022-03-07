package kz.attractor.datamodel.model;

import java.util.HashMap;
import java.util.Map;

public enum ClientStatus {
    CLIENT_NEW("Новый"),
    CLIENT_CONSTANT("Постоянный"),
    CLIENT_ARCHIVE("Архивный");

    public final String label;
    private static final Map<String, ClientStatus> BY_LABEL = new HashMap<>();

    static {
        for(ClientStatus status: values()) {
            BY_LABEL.put(status.label, status);
        }
    }
    private ClientStatus(String label) {
        this.label = label;
    }

    public static ClientStatus valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
