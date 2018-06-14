package com.egs.repo;

import com.egs.model.Comment;
import com.egs.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Hayk_Mkhitaryan
 */
public interface NotificationRepo extends JpaRepository<Notification, Long> {
    List<Comment> findAllCommentsById(Long id);
}
