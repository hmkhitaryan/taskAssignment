package com.egs.service;

import com.egs.model.Comment;
import com.egs.model.Task;

import java.util.List;

/**
 * @author Hayk_Mkhitaryan
 */
public interface NotificationService {
    List<Comment> findAllCommentsById(Long id);

    void saveNotification(Task task);

    void updateNotification(Task task);
}
