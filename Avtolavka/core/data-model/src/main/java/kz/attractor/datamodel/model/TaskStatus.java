package kz.attractor.datamodel.model;

import java.util.HashMap;
import java.util.Map;

public enum TaskStatus {

    TASK_NEW("Новый"),
    TASK_COMPLETED("Закрытый");

    public final String label;
    private static final Map<String, TaskStatus> BY_LABEL = new HashMap<>();

    static {
        for(TaskStatus status: values()) {
            BY_LABEL.put(status.label, status);
        }
    }
    private TaskStatus(String label) {
        this.label = label;
    }

    public static TaskStatus valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
