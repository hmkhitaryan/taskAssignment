package com.egs;

import com.egs.enums.Severity;
import com.egs.enums.Status;
import com.egs.model.Role;
import com.egs.model.Task;
import com.egs.model.User;
import com.egs.repo.RoleRepository;
import com.egs.repo.TaskRepository;
import com.egs.repo.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TaskAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskAssignmentApplication.class, args);
    }

    @Bean
    ApplicationRunner init(TaskRepository taskRepository, RoleRepository roleRepository, UserRepository userRepository) {
        return args -> {
            final Role assigneeRole = new Role("ASSIGNEE_USER");
            final Role reporteeRole = new Role("REPORTER_USER");
            final Role createdAssigneeRole = roleRepository.save(assigneeRole);
            final Role createdReporteeRole = roleRepository.save(reporteeRole);

            final Set<Role> assigneeUserRoles = new HashSet<>();
            assigneeUserRoles.add(createdAssigneeRole);
            final Set<Role> reporterUserRoles = new HashSet<>();
            reporterUserRoles.add(createdReporteeRole);

            final User assigneeUser = new User("haykohayk1", assigneeUserRoles);
            final User reporterUser = new User("haykohayk1", reporterUserRoles);

            final User createdAssigneeUser = userRepository.save(assigneeUser);
            final User createdReporteeUser = userRepository.save(reporterUser);

            final Task task = new Task(createdReporteeUser, createdAssigneeUser, Severity.MAJOR, Status.CREATED, new Date(), "New Task is created");
            final Task taskCreated = taskRepository.save(task);
////            Task task1 = taskRepository.getOne(5L);
////            System.out.println(task1.getStatus());
//            final Long id = taskCreated.getId();
        };
    }
}
