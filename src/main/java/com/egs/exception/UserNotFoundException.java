package com.egs.exception;

/**
 * Created by User on 11.09.2016.
 */
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 7414129986758383880L;

    private String userId;

    private String description;

    public UserNotFoundException(String userId, String description) {
        super(userId);
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }
}
