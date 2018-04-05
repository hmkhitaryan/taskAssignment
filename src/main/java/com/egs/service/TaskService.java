package com.egs.service;

import com.egs.model.Comment;
import com.egs.model.Task;

import java.util.List;

/**
 * @author Hayk_Mkhitaryan
 */
public interface TaskService {

    Task findById(Long id);

    List<Task> findAllByUserId(Long id);

    List<Task> findAll();

    void saveTask(Task task);

    void deleteById(Long id);

    /**
     * Update impl.
     *
     * @param task to be updated
     */
    void updateTask(Task task);

    List<Comment> getAllCommentsById(Long id);
}
