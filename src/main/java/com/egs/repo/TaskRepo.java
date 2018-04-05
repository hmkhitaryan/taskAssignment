package com.egs.repo;

import com.egs.model.Comment;
import com.egs.model.Task;

import java.util.List;

/**
 * @author Hayk_Mkhitaryan
 */
public interface TaskRepo {
    List<Task> findAll();

    Task findById(Long id);

    void save(Task document);

    List<Task> findAllByUserId(Long userId);

    void deleteById(Long id);

    List<Comment> getAllCommentsById(Long id);

}
