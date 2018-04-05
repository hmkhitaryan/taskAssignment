package com.egs.service.impl;

import com.egs.enums.Type;
import com.egs.model.Notification;
import com.egs.model.Task;
import com.egs.repo.NotificationRepo;
import com.egs.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Hayk_Mkhitaryan
 */
@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

    private static final String NEW_TASK_IS_CREATED = "new impl is created";

    private static final String TASK_ASSIGNEE_CHANGED = "impl assignee is changed";

    @Autowired
    private NotificationRepo notificationRepo;

    @Override
    public void saveNotification(Task task) {
        Notification notification = new Notification(
                task.getReporterUser(), task.getAssigneeUser(), NEW_TASK_IS_CREATED, Type.NEW_TASK_CREATED);
        notificationRepo.save(notification);
    }

    @Override
    public void updateNotification(Task task) {
        Notification notification = new Notification(
                task.getReporterUser(), task.getAssigneeUser(), NEW_TASK_IS_CREATED, Type.NEW_TASK_CREATED);
        notificationRepo.save(notification);
    }
}
