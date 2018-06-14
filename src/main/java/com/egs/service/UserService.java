package com.egs.service;

import com.egs.model.User;

public interface UserService {
    User findUserByUsernameAndPassword(String userName, String password);

    User save(User user);
}
