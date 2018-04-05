package com.egs.exception;

/**
 * @author Hayk_Mkhitaryan
 */
public class TaskNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 2839766173688521279L;

    private String taskId;

    public TaskNotFoundException(String taskId) {
        this.taskId = taskId;
    }
}
