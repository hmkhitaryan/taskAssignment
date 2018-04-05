package com.egs.repo;

import com.egs.model.Notification;
import com.egs.model.Task;
import org.springframework.stereotype.Repository;

/**
 * @author Hayk_Mkhitaryan
 */
@Repository("notificationRepository")
public class NotificationRepoImpl extends AbstractDao<Long, Notification> implements NotificationRepo {

    public void save(Notification notification){
        persist(notification);
    }
}
