package com.egs.service.impl;

import com.egs.model.User;
import com.egs.repo.UserRepository;
import com.egs.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Hayk_Mkhitaryan
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User findUserByUsernameAndPassword(String userName, String password) {
        return userRepository.findUserByUsernameAndPassword(userName, password);
    }

   public User save(User user){
        return userRepository.save(user);
   }
}
