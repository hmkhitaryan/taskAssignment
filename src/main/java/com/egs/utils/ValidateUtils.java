package com.egs.utils;

import com.egs.exception.TaskNotFoundException;
import com.egs.exception.UserNotFoundException;
import com.egs.model.Task;
import com.egs.model.User;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author Hayk_Mkhitaryan
 */
public class ValidateUtils {

    public static void validateTask(Task task) {
        Optional<Task> taskValidated = Optional.ofNullable(task);
        if (!taskValidated.isPresent()) {
            throw new TaskNotFoundException("No task found");
        }
        taskValidated.ifPresent(t -> {
            final User assigneeUser = t.getAssigneeUser();
            if (assigneeUser == null || assigneeUser.getId() == null) {
                throw new UserNotFoundException("No assignee user found for this task");
            }
            final User reporterUser = t.getAssigneeUser();
            if (reporterUser == null || reporterUser.getId() == null) {
                throw new UserNotFoundException("No reporter user found for this task");
            }

        });
    }
}
