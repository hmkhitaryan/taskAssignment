package com.egs.controller;

import com.egs.exception.UserNotFoundException;
import com.egs.model.Comment;
import com.egs.model.Task;
import com.egs.service.NotificationService;
import com.egs.service.TaskService;
import com.egs.utils.ValidateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * @author Hayk_Mkhitaryan
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/assignment/users/{id}")
    public ResponseEntity<List<Task>> getTasksByAssignee(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(taskService.findAllByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<Comment>> getTaskCommentsById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(notificationService.findAllCommentsById(id), HttpStatus.OK);
    }

    // task CRUD
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") Long id) {
        final Task task = taskService.findByIdJoinFetch(id);
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        ValidateUtils.validateTask(task);
        taskService.saveTask(task);
        notificationService.saveNotification(task);
        LOGGER.info("task with id {} successfully created", task.getId());

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        taskService.updateTask(task);

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id) {
        try {
            taskService.deleteById(id);
            LOGGER.info("task with id {} successfully deleted", id);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Task> handleNotFoundError() {
        LOGGER.warn("no entity found with specified identifier");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IllegalStateException.class, UserNotFoundException.class})
    public ResponseEntity<Task> handleEntityCreationError() {
        LOGGER.warn("Any of users of the specified task not found");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
