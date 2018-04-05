package com.egs.auth;

import com.egs.model.User;

import java.util.Date;

/**
 * @author Hayk_Mkhitaryan
 */
public class Token {

    private User user;

    private String token;

    private Date expirationDate;

    public Token(User user, String token, Date expirationDate) {
        this.user = user;
        this.token = token;
        this.expirationDate = expirationDate;
    }

}
