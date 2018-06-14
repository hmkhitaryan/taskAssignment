package com.egs.utils;

import com.egs.exception.TaskNotFoundException;
import com.egs.exception.UserNotFoundException;
import com.egs.model.Task;

import javax.persistence.EntityNotFoundException;

/**
 * @author Hayk_Mkhitaryan
 */
public class ValidateUtils {

    public static void validateTask(Task task){
        if(task != null){
            if(task.getAssigneeUser() == null || task.getReporterUser() == null){
                throw new UserNotFoundException("Either assignee or reporter of that task not found");
            }
        } else {
            throw new TaskNotFoundException("No task found");
        }
    }
}
