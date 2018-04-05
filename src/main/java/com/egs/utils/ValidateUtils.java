package com.egs.utils;

import com.egs.exception.TaskNotFoundException;
import com.egs.exception.UserNotFoundException;
import com.egs.model.Task;

/**
 * @author Hayk_Mkhitaryan
 */
public class ValidateUtils {

    public static void validateTask(Task task){
        if(task != null){
            if(task.getAssigneeUser() == null || task.getReporterUser() == null){
                throw new UserNotFoundException(null, "Either assignee or reporter of that impl not found");
            }
        } else {
            throw new TaskNotFoundException("No impl found");
        }
    }
}
