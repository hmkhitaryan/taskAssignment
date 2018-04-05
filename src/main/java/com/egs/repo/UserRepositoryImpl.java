package com.egs.repo;

import com.egs.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * @author Hayk_Mkhitaryan
 */
@Repository
public class UserRepositoryImpl extends AbstractDao<Long, User> implements UserRepository {

    public User findUserByUsernameAndPassword(String userName, String password) {
        final Criteria criteria = createEntityCriteria();
        final Criteria userCriteria = criteria.createCriteria("user");
        userCriteria.add(Restrictions.eq("username", userName)).add(
                Restrictions.eq("password", password));

        return (User) criteria.uniqueResult();
    }
}
