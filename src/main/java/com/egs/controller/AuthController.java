package com.egs.controller;

import com.egs.auth.Token;
import com.egs.model.User;
import com.egs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @author Hayk_Mkhitaryan
 */
public class AuthController {

    @Autowired
    private UserService userService;

    public void doAuth() {
        String username = "admin";
        String password = "123";

        User user = userService.findUserByUsernameAndPassword(username, password);
        if (user != null) {
            String tokenStr = UUID.randomUUID().toString();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MINUTE, 30);
            Date expDate = calendar.getTime();
            Token token = new Token(user, tokenStr, expDate);
            token.save();
        }

        return token;
    }

    // Do this in Spring security filter chain
    public boolean checkToken(String token) {
        // token taken from request header
        Token token = TokenDao.findByToken(token);
        if (token != null) {
            token.expirationDate.before(new Date()) {
                ///validated
                return true;
            }
        }

        return false;
    }
}
