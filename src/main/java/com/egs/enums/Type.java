package com.egs.enums;

/**
 * @author Hayk_Mkhitaryan
 */
public enum Type {
    NEW_TASK_CREATED("new task created"),
    STATUS_CHANGED("status changed"),
    COMMENT("comment"),
    ASSIGNEE_CHANGED("assignee changed"),
    TASK_SEVERITY_CHANGED("task severity changed");

    private String name;

    Type(String name) {
        this.name = name;
    }
}

