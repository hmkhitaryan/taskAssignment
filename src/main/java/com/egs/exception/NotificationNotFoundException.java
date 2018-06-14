package com.egs.exception;

public class NotificationNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 2839766454558521279L;
    private String message;

    public NotificationNotFoundException(String message) {
        this.message = message;
    }
}
