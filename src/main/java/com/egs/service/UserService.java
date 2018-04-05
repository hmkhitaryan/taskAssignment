package com.egs.service;

import com.egs.model.User;
import com.egs.repo.UserRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Hayk_Mkhitaryan
 */
@Service
@Transactional
public class UserService {

    private UserRepositoryImpl userRepository;

    public User findUserByUsernameAndPassword(String userName, String password) {
        return userRepository.findUserByUsernameAndPassword(userName, password);
    }
}
