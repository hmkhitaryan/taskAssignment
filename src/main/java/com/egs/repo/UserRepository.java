package com.egs.repo;

import com.egs.model.User;

/**
 * @author Hayk_Mkhitaryan
 */
interface UserRepository {

    User findUserByUsernameAndPassword(String userName, String password);
}
