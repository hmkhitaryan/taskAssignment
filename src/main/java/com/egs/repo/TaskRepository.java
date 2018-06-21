package com.egs.repo;

import com.egs.model.Comment;
import com.egs.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Hayk_Mkhitaryan
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t join fetch t.reporterUser join fetch t.assigneeUser WHERE t.id = :id")
    Task findByIdJoinFetch(@Param("id") Long id);

    List<Task> findAllById(Long id);
}
