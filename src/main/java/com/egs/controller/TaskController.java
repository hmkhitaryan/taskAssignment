package com.egs.controller;

import com.egs.enums.Type;
import com.egs.exception.UserNotFoundException;
import com.egs.model.Comment;
import com.egs.model.Notification;
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
    public List<Task> getTasksByAssignee(@PathVariable("id") Long userId) {
        return taskService.findAllByUserId(userId);
    }

    @GetMapping("/{id}/comments")
    @ResponseBody
    public List<Comment> getTaskCommentsById(@PathVariable("id") Long id) {
        return taskService.getAllCommentsById(id);
    }

    // impl CRUD
    @SuppressWarnings("unchecked")
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity getTask(@PathVariable("id") Long id) {

        Task task = taskService.findById(id);
        if (task == null) {
            return new ResponseEntity("No Tasks found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(task, HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @PostMapping(value = "/")
    public ResponseEntity createTask(@RequestBody Task task) {
        ValidateUtils.validateTask(task);
        taskService.saveTask(task);
        notificationService.saveNotification(task);
        LOGGER.info("impl with id {} successfully created", task.getId());

        return new ResponseEntity(task, HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @PutMapping("/{id}")
    public ResponseEntity updateTask(@RequestBody Task task) {
        taskService.updateTask(task);

        return new ResponseEntity(task, HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@PathVariable Long id) {
        try {
            taskService.deleteById(id);
            LOGGER.info("impl with id {} successfully deleted", id);
        } catch (UserNotFoundException e) {
            return new ResponseEntity("No tasks found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(id, HttpStatus.OK);
    }


    @SuppressWarnings("unchecked")
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handleUserError() {
        return new ResponseEntity("No tasks found for that user", HttpStatus.NOT_FOUND);
    }
}
