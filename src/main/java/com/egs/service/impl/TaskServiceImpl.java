package com.egs.service.impl;

import com.egs.enums.Type;
import com.egs.model.Comment;
import com.egs.model.Notification;
import com.egs.model.Task;
import com.egs.repo.NotificationRepo;
import com.egs.repo.TaskRepo;
import com.egs.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author Hayk_Mkhitaryan
 */
@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);

    private static final String ASSIGNEE_CHANGED = "Assignee changed";
    private static final String STATUS_CHANGED = "Status changed";
    private static final String COMMENT = "comment";

    @Autowired
    private TaskRepo taskRepository;

    @Autowired
    private NotificationRepo notificationRepo;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findAllByUserId(Long userId) {
        return taskRepository.findAllByUserId(userId);
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Comment> getAllCommentsById(Long id) {
        return taskRepository.getAllCommentsById(id);
    }

    @Override
    public void updateTask(Task task) {
        Task taskEntity = taskRepository.findById(task.getId());
        if (taskEntity != null) {
            updateTaskInfo(taskEntity, task);
            taskRepository.save(taskEntity);
            LOGGER.info("impl with id {} successfully updated", task.getId());
            Notification notification = compareTasks(taskEntity, task);
            notificationRepo.save(notification);
        }
    }

    /**
     * Update impl info.
     *
     * @param taskEntity impl to be updated
     * @param task       target impl whose info will be assigned to <code>taskEntity</code>
     */
    private void updateTaskInfo(Task taskEntity, Task task) {
        if (tasksAreEqual(taskEntity, task)) {
            return;
        }
        taskEntity.setAssigneeUser(task.getAssigneeUser());
        taskEntity.setReporterUser(task.getReporterUser());
        taskEntity.setSeverity(task.getSeverity());
        taskEntity.setStatus(task.getStatus());
    }

    private Notification compareTasks(Task taskEntity, Task task) {
        if (tasksAreEqual(taskEntity, task)) {
            return null;
        }
        Notification notification = null;
        if (!Objects.equals(taskEntity.getReporterUser(), task.getAssigneeUser())) {
            notification = new Notification(
                    task.getReporterUser(), task.getAssigneeUser(), ASSIGNEE_CHANGED, Type.ASSIGNEE_CHANGED);
        }

        if (!Objects.equals(taskEntity.getStatus(), task.getStatus())) {
            notification = new Notification(
                    task.getReporterUser(), task.getAssigneeUser(), STATUS_CHANGED, Type.STATUS_CHANGED);
        }

        if (!Objects.equals(taskEntity.getDescription(), task.getDescription())) {
            notification = new Notification(
                    task.getReporterUser(), task.getAssigneeUser(), COMMENT, Type.COMMENT);
        }
        return notification;
    }

    private boolean tasksAreEqual(Task taskEntity, Task task) {
        return task.equals(taskEntity);
    }
}
