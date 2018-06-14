package com.egs.service;

import com.egs.model.Comment;
import com.egs.model.Task;

import java.util.List;

/**
 * @author Hayk_Mkhitaryan
 */
public interface TaskService {

    Task findById(Long id);

    Task findByIdJoinFetch(Long id);

    List<Task> findAllByUserId(Long id);

    List<Task> findAll();

    Task saveTask(Task task);

    void deleteById(Long id);

    /**
     * Update task.
     *
     * @param task to be updated
     */
    void updateTask(Task task);
}
