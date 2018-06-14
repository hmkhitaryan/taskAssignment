package com.egs.repo;

import com.egs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hayk_Mkhitaryan
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsernameAndPassword(String userName, String password);
}
