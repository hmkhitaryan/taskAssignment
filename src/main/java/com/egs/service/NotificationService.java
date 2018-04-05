package com.egs.service;

import com.egs.model.Task;

/**
 * @author Hayk_Mkhitaryan
 */
public interface NotificationService {

    void saveNotification(Task task);

    void updateNotification(Task task);
}
